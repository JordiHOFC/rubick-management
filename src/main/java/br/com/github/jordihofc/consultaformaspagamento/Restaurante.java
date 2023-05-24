package br.com.github.jordihofc.consultaformaspagamento;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Entity
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String nome;


    @JoinTable(indexes = {@Index(name = "restaurante_id", columnList = "restaurante_id")})
    @ManyToMany
    private List<FormaDePagamento> formaDePagamentos = new ArrayList<>();

    public Restaurante(String nome, List<FormaDePagamento> formaDePagamentos) {
        this.nome = nome;
        this.formaDePagamentos = formaDePagamentos;
    }

    @Deprecated
    public Restaurante() {
    }

    public List<FormaDePagamento> getFormaDePagamentos() {
        return formaDePagamentos;
    }

    public boolean aceita(FormaDePagamento formaDePagamento) {
        return this.formaDePagamentos.contains(formaDePagamento);
    }

    public List<FormaDePagamento> meiosDePagamentoPara(Usuario usuario) {

        Predicate<FormaDePagamento> existeFormaDePagamentoEmComumComUsuario = formaDePagamentoRestaurante -> usuario.getFormaDePagamentos()
                .stream()
                .anyMatch(formaDePagamentoUsuario -> formaDePagamentoUsuario.equals(formaDePagamentoRestaurante));

        return this.formaDePagamentos.stream()
                .filter(existeFormaDePagamentoEmComumComUsuario)
                .collect(Collectors.toList());
    }

    public List<FormaDePagamento> meiosDePagamentoParaUsuarioSuspeitoFraude(Usuario usuario) {

        Predicate<FormaDePagamento> existeFormaDePagamentoEmComumComUsuario = formaDePagamentoRestaurante -> usuario.getFormaDePagamentos()
                .stream()
                .anyMatch(formaDePagamentoUsuario -> formaDePagamentoUsuario.equals(formaDePagamentoRestaurante));

        return this.formaDePagamentos.stream()
                .filter(existeFormaDePagamentoEmComumComUsuario)
                .filter(FormaDePagamento::disponivelOffline)
                .collect(Collectors.toList());

    }

    public Long getId() {
        return this.id;
    }
}

