package br.com.rafael.reviewspringunittestapi.services.exception;

public class DataIntegrateViolationException extends RuntimeException {

    public DataIntegrateViolationException(String message) {
        super(message);
    }
}
