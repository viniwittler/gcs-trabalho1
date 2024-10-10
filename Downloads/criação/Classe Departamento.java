static class Departamento {
    private String nome;
    private double limite;

    public Departamento(String nome, double limite) {
        this.nome = nome;
        this.limite = limite;
    }

    public String getNome() {
        return nome; }
    public double getLimite() {
        return limite; }
}