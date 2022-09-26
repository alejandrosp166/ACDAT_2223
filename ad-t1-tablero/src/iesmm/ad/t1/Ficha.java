public enum Ficha{
    VALOR1("❌"), VALOR2("\uD83D\uDD34");

    private String valor;

    private Ficha(String valor){
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}