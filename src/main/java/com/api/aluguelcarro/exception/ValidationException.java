package com.api.aluguelcarro.exception;

public class ValidationException extends Exception{

    public ValidationException(String erro){
        super(erro);
    }
}
