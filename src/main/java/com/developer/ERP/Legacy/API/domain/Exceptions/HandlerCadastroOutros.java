package com.developer.ERP.Legacy.API.domain.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class HandlerCadastroOutros extends RuntimeException {

	private static final long serialVersionUID = 9052849609623542609L;
	
	public HandlerCadastroOutros(String message) {
		super(message);
	}

}
