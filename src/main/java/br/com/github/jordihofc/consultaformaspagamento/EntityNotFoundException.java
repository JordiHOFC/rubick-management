package br.com.github.jordihofc.consultaformaspagamento;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class EntityNotFoundException extends Exception {


    public EntityNotFoundException(String mensagem) {
        super(mensagem);
    }
}
