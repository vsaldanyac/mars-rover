package com.abba.english.marsrover.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "There are no texts stored to transmit")
public class NoTextsToTransmitException extends RuntimeException {

}
