package br.com.github.jordihofc.consultaformaspagamento;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
public class ConsultaFormasDePagamentoController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RestauranteRepository restauranteRepository;
    @Autowired
    private FormaDePagamentoRepository formaDePagamentoRepository;

    //injeção de dependencias omitidos

    @Transactional(readOnly = true)
    @GetMapping("/api/v1/formas-de-pagamento")
    public ResponseEntity<?> consultarFormasDePagamentoEmComum(
            @RequestParam(required = false) Long usuarioId,
            @RequestParam(required = false) Long restauranteId){

        if (usuarioRepository.existsById(usuarioId)) {
            throw new ResponseStatusException(UNPROCESSABLE_ENTITY, "Usuario não cadastrado");
        }

        if (restauranteRepository.existsById(restauranteId)) {
            throw new ResponseStatusException(UNPROCESSABLE_ENTITY, "Restaurante não cadastrado");
        }

        var formasPagamentoComum = formaDePagamentoRepository.findFormaDePagamentoEmComumEntre(usuarioId, restauranteId)
                .stream()
                .map(FormaDePagamentoResponse::new).toList();

        return ResponseEntity.ok(formasPagamentoComum);
    }
}
