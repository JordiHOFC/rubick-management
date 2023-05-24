//package br.com.github.jordihofc.consultaformaspagamento;
//
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.ArraySchema;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class ConsultaFormasDePagamentoController2 {
//    @Autowired
//    private ConsultaFormaDePagamentoService consultaFormaDePagamentoService;
//
//    @Operation(summary = "Listar formas de pagamento em comum entre um usuario e restaurante")
//    @ApiResponse(
//            responseCode = "200",
//            description = "Lista as formas de pagamento em comum entre um usuario e restaurante  ou lista vazia",
//            content = @Content(
//                    mediaType = "application/json",
//                    array = @ArraySchema(schema = @Schema(implementation = FormaDePagamentoResponse.class))
//            )
//    )
//
//    @GetMapping("/api/v1/formas-de-pagamento")
//    public ResponseEntity<?> consultarFormasDePagamentoEmComum(
//            @RequestParam(required = false) Long usuarioId,
//            @RequestParam(required = false) Long restauranteId) throws EntityNotFoundException {
//
//        var formaDePagamentos = consultaFormaDePagamentoService
//                .consultarFormaDePagamentoEmComum(usuarioId, restauranteId);
//
//        var formasDePagamentoEmComum = formaDePagamentos.stream()
//                .map(FormaDePagamentoResponse::new)
//                .toList();
//
//        return ResponseEntity.ok(formasDePagamentoEmComum);
//    }
//}
