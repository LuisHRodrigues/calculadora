
/*
 * Aluno: Luis Henrique Rodrigues de Oliveira
 * Data de criação: 25/03/2025
 */

package br.edu.ifgoiano.urutai.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException {

    public UnsupportedMathOperationException(String x) {
        super(x);
    }

    private static final long serialVersionUID = 1L;

}
