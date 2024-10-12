package dados;

import java.util.Objects;

public class Item {

    private String descricao;
    private double valorUnitario;
    private int quantidade;

    public Item(String descricao, double valorUnitario, int quantidade) {
        if (valorUnitario < 0) {
            throw new IllegalArgumentException("Valor unitário não pode ser negativo.");
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa.");
        }
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorUnitario * quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public String toString() {
        return String.format("Item: %s, Valor Unitário: %.2f, Quantidade: %d, Valor Total: %.2f",
                descricao, valorUnitario, quantidade, getValorTotal());
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Item)) return false;
        Item item = (Item) obj;
        return Double.compare(item.valorUnitario, valorUnitario) == 0 &&
               quantidade == item.quantidade &&
               descricao.equals(item.descricao);
    }

    public int hashCode() {
        return Objects.hash(descricao, valorUnitario, quantidade);
    }

    public Item clone() {
        return new Item(this.descricao, this.valorUnitario, this.quantidade);
    }
}
