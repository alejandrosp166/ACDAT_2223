public enum Ficha{
    VALOR1("\uD83D\uDD34"), VALOR2("❌");

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