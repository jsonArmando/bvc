package com.bvc.test.exception;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@Data
public class ErrorMessage {
    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;
}
