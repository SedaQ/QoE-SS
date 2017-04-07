package cz.vutbr.feec.seda.exceptions;

import org.springframework.dao.DataAccessException;

/**
 * @author Pavel Šeda (441048)
 *
 */
public class ServiceLayerException extends DataAccessException {

	private static final long serialVersionUID = 8606352464618478989L;

	public ServiceLayerException(String message) {
		super(message);
	}

	public ServiceLayerException(String message, Throwable cause) {
		super(message, cause);
	}
}
