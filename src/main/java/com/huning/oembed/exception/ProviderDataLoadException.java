package com.huning.oembed.exception;

import org.springframework.http.HttpStatus;

public class ProviderDataLoadException extends AppException {

	private static final String MESSAGE = "PROVIDER_DATA_LOAD_ERROR";

	public ProviderDataLoadException() {
		super(MESSAGE);
	}

	public ProviderDataLoadException(String message) {
		super(message);
	}

	public ProviderDataLoadException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProviderDataLoadException(Throwable cause) {
		super(MESSAGE, cause);
	}

	@Override
	public HttpStatus getStatusCode() {
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}
}
