/*  Original Licensing Copyright
 * 
 *  Chemoinformatics REST Service Controller Exception Handler.
 *  Copyright (C) 2021  DZ-FSDev
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.dz_fs_dev.chemistry.spring.exceptionHandler;

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
 * @version 0.0.2
 */
@ControllerAdvice
public class RESTContollerExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler
	protected ResponseEntity<Object> handleConflict(InvalidSmilesException ex, WebRequest request) {
		Map<String, Object> errorAttributes = new HashMap<String, Object>();
		request.getParameterMap();

		errorAttributes.put("exception", ex.getMessage());
		ex.printStackTrace();
		errorAttributes.put("request", request.toString());
		errorAttributes.put("httpStatusString", HttpStatus.BAD_REQUEST);
		errorAttributes.put("httpStatus", HttpStatus.BAD_REQUEST.value());
		errorAttributes.put("locale", request.getLocale());

		return handleExceptionInternal(ex, errorAttributes, 
				new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
}
