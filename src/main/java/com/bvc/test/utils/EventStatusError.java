package com.bvc.test.utils;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@ToString
public enum EventStatusError {

    UNEXPECTED_ERROR(0, "Unexpected error."),
    BAD_REQUEST_INVALID_ARGUMENTS(1,"Validation error. Detail in the 'errors' field."),
    BAD_REQUEST_INVALID_PARAMETERS(2, "Missing required parameter."),
    ENDPOINT_NOT_FOUND(3, "Endpoint not found."),
    RESOURCE_EVENT_STATUS_NOT_FOUND(100, "EVENT status resource not found."),
    MAX_DUPLICATE(1, "Evaluates the duplicate value."),
    ERROR_UNIQUE(2,"The COMMODITY is duplicated."),
    ERROR_EVENT(3,"Enter an EVENT"),
    ERROR_PERCENTAGE(4,"Percentage error should not be greater than 100%");

    private final Integer code;
    private final String message;

    public HttpStatus getStatus() {
        switch (this) {
            case BAD_REQUEST_INVALID_ARGUMENTS:
            case BAD_REQUEST_INVALID_PARAMETERS:
                return HttpStatus.BAD_REQUEST;
            case ENDPOINT_NOT_FOUND:
            case RESOURCE_EVENT_STATUS_NOT_FOUND:
                return HttpStatus.NOT_FOUND;
            case ERROR_PERCENTAGE:
            case ERROR_UNIQUE:
            case MAX_DUPLICATE:
                return HttpStatus.NOT_FOUND;
            default:
                return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
