package br.com.github.jordihofc.consultaformaspagamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ConsultaFormaDePagamentoService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RestauranteRepository restauranteRepository;

    @Transactional(readOnly = true)
    @Cacheable(value = "formas_de_pagamento_em_comum", key = "T(java.util.Objects).hash(#usuarioId,#restaureanteId)")
    public List<FormaDePagamento> consultarFormaDePagamentoEmComum(Long usuarioId, Long restauranteId) throws EntityNotFoundException {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario não cadastrado"));


        Restaurante restaurante = restauranteRepository.findById(restauranteId)
                .orElseThrow(() -> new EntityNotFoundException("Restaurante não cadastrado"));

        return restaurante.meiosDePagamentoPara(usuario)
                .stream()
                .toList();
    }
}
