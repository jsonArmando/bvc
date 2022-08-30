package com.bvc.test.exception;

import com.bvc.test.utils.EventStatusError;

public class EventStatusException extends Exception{
    private final EventStatusError eventStatusError;
    public EventStatusException(EventStatusError eventStatusError){
        super(eventStatusError == null ? null : eventStatusError.getMessage()); //no cause, customer throws
        this.eventStatusError = eventStatusError;
    }
    public EventStatusException(EventStatusError eventStatusError, Exception exception){
        super(exception);
        this.eventStatusError =eventStatusError;
    }
}

