static class Item {
    private String descricao;
    private double valorUnitario;
    private int quantidade;

    public Item(String descricao, double valorUnitario, int quantidade) {
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    public double total() {
        return valorUnitario * quantidade;
    }
    
    public String getDescricao() {
        return descricao; }
    public double getValorUnitario() {
        return valorUnitario; }
    public int getQuantidade() {
        return quantidade; }
}