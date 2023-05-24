package br.com.github.jordihofc.consultaformaspagamento;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @ManyToMany
    @JoinTable(indexes = {@Index(name = "usuario_id", columnList = "usuario_id")})
    private List<FormaDePagamento> formaDePagamentos = new ArrayList<>();

    public Usuario(String nome, String email, FormaDePagamento formaDePagamento) {
        this.nome = nome;
        this.email = email;

    }

    @Deprecated
    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public List<FormaDePagamento> getFormaDePagamentos() {
        return formaDePagamentos;
    }

    public boolean aceita(FormaDePagamento formaDePagamento) {
        return this.getFormaDePagamentos().contains(formaDePagamento);
    }

}
