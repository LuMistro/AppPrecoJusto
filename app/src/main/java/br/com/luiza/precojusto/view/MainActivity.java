package br.com.luiza.precojusto.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import br.com.luiza.precojusto.R;
import br.com.luiza.precojusto.contoller.ProdutoControl;
import br.com.luiza.precojusto.model.Produto;

public class MainActivity extends AppCompatActivity {

    private Produto produto;

    private ProdutoControl control;

    private EditText etNomeProduto;
    private EditText etValor;
    private EditText etQtdParcelas;
    private EditText etJuros;

    private TextView tvNomeProduto;
    private TextView tvValorInicial;
    private TextView tvValorParcela;
    private TextView tvValorTotal;
    private TextView tvTotalJuros;

    private String resNome;
    private String resValorInicial;
    private String resValorParcela;
    private String resValorTotal;
    private String resTotalJuros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void inicializaObjetos() {
        produto = new Produto();
        control = new ProdutoControl();

        etNomeProduto = findViewById(R.id.etNomeProduto);
        etValor = findViewById(R.id.etValor);
        etQtdParcelas = findViewById(R.id.etParcelas);
        etJuros = findViewById(R.id.etJuros);


        tvNomeProduto = findViewById(R.id.tvNomeProduto);
        tvValorInicial = findViewById(R.id.valorInicial);
        tvValorParcela = findViewById(R.id.valorParcela);
        tvValorTotal = findViewById(R.id.valorTotal);
        tvTotalJuros = findViewById(R.id.totalJuros);

        resNome = getString(R.string.nome_produto);
        resValorInicial = getString(R.string.valorInicial);
        resValorParcela = getString(R.string.valorParcela);
        resValorTotal = getString(R.string.valorTotal);
        resTotalJuros = getString(R.string.valorJuros);
    }

    private void pegaDadosTela() {
        inicializaObjetos();
        if (!String.valueOf(etNomeProduto.getText()).equals("")) {
            produto.setNome(String.valueOf(etNomeProduto.getText()));
        } else {
            produto.setNome("Não Informado");
        }

        if (!etValor.getText().toString().equals("")) {
            produto.setValorInicial(Double.valueOf(etValor.getText().toString()));
        } else {
            produto.setValorInicial(0.0);
        }

        if (!etJuros.getText().toString().equals("")) {
            produto.setJuros(control.calculaJuros(Double.valueOf(etJuros.getText().toString()), produto));
        } else {
            produto.setJuros(0.0);
        }
        produto.setValorFinal(control.calculaValorFinal(produto));

        if (!etQtdParcelas.getText().toString().equals("")) {
            produto.setValorParcelas(control.calculaValorParcelas(Integer.valueOf(etQtdParcelas.getText().toString()), produto));
        } else {
            produto.setValorParcelas(0.0);
        }
    }

    public void mostraNaTela(View view) {
        pegaDadosTela();
        tvNomeProduto.setText(resNome + produto.getNome());
        tvValorInicial.setText(resValorInicial + "R$" + produto.getValorInicial().toString());
        tvValorParcela.setText(resValorParcela + "R$" + produto.getValorParcelas().toString());
        tvValorTotal.setText(resValorTotal + "R$" + produto.getValorFinal().toString());
        tvTotalJuros.setText(resTotalJuros + "R$" + produto.getJuros().toString());
    }

    public void limparDados(View view) {
        tvNomeProduto.setText("");
        tvValorInicial.setText("");
        tvValorParcela.setText("");
        tvValorTotal.setText("");
        tvTotalJuros.setText("");

        etNomeProduto.setText("");
        etValor.setText("");
        etQtdParcelas.setText("");
        etJuros.setText("");
    }

}
