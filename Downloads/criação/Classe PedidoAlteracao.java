package dados;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    enum Status {
        ABERTO, APROVADO, REPROVADO, CONCLUIDO
    }

    private Funcionario solicitante;
    private Departamento departamento;
    private String dataPedido;
    private String dataConclusao;
    private Status status;
    private List<Item> itens;
    private double valorTotal;

    public Pedido(Funcionario solicitante, String dataPedido) {
        this.solicitante = solicitante;
        this.departamento = solicitante.getDepartamento();
        this.dataPedido = dataPedido;
        this.status = Status.ABERTO;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        this.itens.add(item);
        calcularValorTotal();
    }

    private void calcularValorTotal() {
        valorTotal = itens.stream().mapToDouble(Item::getValorTotal).sum();
    }

    public Funcionario getSolicitante() {
        return solicitante;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public String getDataConclusao() {
        return dataConclusao;
    }

    public Status getStatus() {
        return status;
    }

    public List<Item> getItens() {
        return itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setStatus(Status status) throws Exception {
        if (this.status == Status.ABERTO && (status == Status.APROVADO || status == Status.REPROVADO)) {
            this.status = status;
        } else {
            throw new Exception("Não é possível alterar o status do pedido.");
        }
    }

    public void concluirPedido(String dataConclusao) {
        if (status == Status.APROVADO) {
            this.dataConclusao = dataConclusao;
            this.status = Status.CONCLUIDO;
        } else {
            throw new IllegalStateException("Somente pedidos aprovados podem ser concluídos.");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Status: " + status);
        sb.append("\nData do Pedido: " + dataPedido);
        sb.append("\nSolicitante: " + solicitante.getNome());
        sb.append("\nDepartamento: " + departamento.getNome());

        if (dataConclusao != null) {
            sb.append("\nData de Conclusão: " + dataConclusao);
        }

        sb.append("\nItens: ");
        for (Item item : itens) {
            sb.append("\n- " + item.toString());
        }

        sb.append("\nValor Total: " + String.format("%.2f", valorTotal));
        return sb.toString();
    }
}