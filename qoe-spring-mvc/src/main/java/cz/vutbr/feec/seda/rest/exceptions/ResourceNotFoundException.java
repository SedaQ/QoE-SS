package cz.vutbr.feec.seda.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Pavel Šeda (441048)
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The requested resource was not found")
public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException() {
	}
	
	public ResourceNotFoundException(Exception ex) {
	}

	private static final long serialVersionUID = 9123201362375836639L;

}
