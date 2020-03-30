package br.com.luiza.precojusto.contoller;

import br.com.luiza.precojusto.model.Produto;

public class ProdutoControl {

    public Double calculaJuros(Double juros, Produto produto) {
        return produto.getValorInicial() * (juros / 100);
    }

    public Double calculaValorParcelas(Integer quantidadeParcelas, Produto produto) {
        return produto.getValorFinal() / quantidadeParcelas;

    }

    public Double calculaValorFinal(Produto produto) {
        return produto.getValorInicial() + produto.getJuros();
    }
}
