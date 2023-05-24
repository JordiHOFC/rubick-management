package br.com.github.jordihofc.consultaformaspagamento;

public class FormaDePagamentoResponse {
    private Long id;
    private String descricao;
    private String formaDePagamento;


    public FormaDePagamentoResponse(FormaDePagamento formaDePagamento) {
        this.id = formaDePagamento.getId();
        this.descricao = formaDePagamento.getDescricao();
        this.formaDePagamento = formaDePagamento.getTipo().name();
    }

    public FormaDePagamentoResponse() {
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }
}
