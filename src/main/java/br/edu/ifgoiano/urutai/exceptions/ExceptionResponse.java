

/*
 * Aluno: Luis Henrique Rodrigues de Oliveira
 * Data de criação: 25/03/2025
 */

package br.edu.ifgoiano.urutai.exceptions;

import java.io.Serializable;
import java.util.Date;

// Classe que representa a estrutura de resposta para exceções
public class ExceptionResponse implements Serializable {
    private static final long serialVersionUID = 1L; // Identificador para serialização

    private Date timestamp; // Momento em que a exceção ocorreu
    private String message; // Mensagem de erro
    private String details; // Detalhes adicionais sobre a exceção

    // Construtor que inicializa os atributos da exceção
    public ExceptionResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    // Métodos getters para acessar os atributos
    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

}
