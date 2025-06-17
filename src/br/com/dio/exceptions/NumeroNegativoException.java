package br.com.dio.exceptions;

public class NumeroNegativoException extends RuntimeException {
    public NumeroNegativoException(String message) {
        super(message);
    }
}
