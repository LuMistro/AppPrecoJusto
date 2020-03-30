package br.com.luiza.precojusto.model;

public class Produto {

    private String nome;
    private Double valorInicial;
    private Double valorParcelas;
    private Double juros;
    private Double valorFinal;

    public Produto() {
    }

    public Produto(String nome, Double valorInicial, Double valorParcelas, Double juros, Double valorFinal) {
        this.nome = nome;
        this.valorInicial = valorInicial;
        this.valorParcelas = valorParcelas;
        this.juros = juros;
        this.valorFinal = valorFinal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Double getValorParcelas() {
        return valorParcelas;
    }

    public void setValorParcelas(Double valorParcelas) {
        this.valorParcelas = valorParcelas;
    }

    public Double getJuros() {
        return juros;
    }

    public void setJuros(Double juros) {
        this.juros = juros;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }
}
