package br.com.rafael.reviewspringunittestapi.resource.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class StandardError {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String path;
}
