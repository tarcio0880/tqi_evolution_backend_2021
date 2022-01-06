package com.app.exception;

import java.util.List;
import java.util.stream.Collectors;

public class GenericException extends RuntimeException {

    public GenericException(String mensagem) {
        super(mensagem);
    }

    public GenericException(List<String> erros) {
        super(erros.stream().collect(Collectors.joining("\n")));
    }

}