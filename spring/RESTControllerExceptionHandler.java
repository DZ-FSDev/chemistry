package com.dz_fs_dev.chemistry.spring;

import java.util.HashMap;
import java.util.Map;

import org.openscience.cdk.exception.InvalidSmilesException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Chemoinformatics REST Service Controller Exception Handler.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
@ControllerAdvice
public class RESTContollerExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler
	protected ResponseEntity<Object> handleConflict(InvalidSmilesException ex, WebRequest request) {
		Map<String, Object> errorAttributes = new HashMap<String, Object>();
		request.getParameterMap();

		errorAttributes.put("exception", ex.getMessage());
		errorAttributes.put("request", request.toString());
		errorAttributes.put("httpStatusString", HttpStatus.BAD_REQUEST);
		errorAttributes.put("httpStatus", HttpStatus.BAD_REQUEST.value());
		errorAttributes.put("locale", request.getLocale());

		return handleExceptionInternal(ex, errorAttributes, 
				new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
}
