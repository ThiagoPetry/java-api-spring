package br.com.senai.domain.exception;

public class NegocioException extends RuntimeException {

    public NegocioException(String message) {
        super(message);
    }
}
