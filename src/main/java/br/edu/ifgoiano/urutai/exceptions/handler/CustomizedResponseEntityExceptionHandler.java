
/*
 * Aluno: Luis Henrique Rodrigues de Oliveira
 * Data de criação: 25/03/2025
 */

package br.edu.ifgoiano.urutai.exceptions.handler;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.edu.ifgoiano.urutai.exceptions.ExceptionResponse;
import br.edu.ifgoiano.urutai.exceptions.UnsupportedMathOperationException;

// Classe global para tratar exceções na aplicação
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    // Manipula todas as exceções genéricas
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(), // Registra o momento da exceção
                ex.getMessage(), // Obtém a mensagem da exceção
                request.getDescription(false) // Obtém detalhes adicionais da requisição
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR); // Retorna erro 500
    }

    // Manipula exceções específicas de operações matemáticas não suportadas
    @ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST); // Retorna erro 400

    }
}
