package com.seda.qoe.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The requested resource was not found")
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 9123201362375836639L;

}
