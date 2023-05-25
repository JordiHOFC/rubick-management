package br.com.github.jordihofc.consultaformaspagamento;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FormaDePagamentoRepository extends JpaRepository<FormaDePagamento, Long> {

    @Cacheable(value = "forma_de_pagamento_entre", key = "T(java.util.Objects).hash(#usuarioId,#restauranteId)")
    @Query(nativeQuery = true, value = """
                SELECT f.*
                  FROM usuario_forma_de_pagamentos u
            INNER JOIN forma_de_pagamento f 
                    ON f.id = u.forma_de_pagamentos_id
            INNER JOIN restaurante_forma_de_pagamentos r
                    ON f.id = r.forma_de_pagamentos_id
                 WHERE u.usuario_id  = :usuarioId
                   AND r.restaurante_id  = :restauranteId        
            """)
    List<FormaDePagamento> findFormaDePagamentoEmComumEntre(Long usuarioId, Long restauranteId);

}
