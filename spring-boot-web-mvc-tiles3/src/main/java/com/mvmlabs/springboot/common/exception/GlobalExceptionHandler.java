package com.mvmlabs.springboot.common.exception;


import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(value = { Exception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	protected ErrorMessage handleConflict(RuntimeException ex, WebRequest request) {
		ErrorMessage em = new ErrorMessage(request.toString());
		em.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		
		if(ex.getMessage() == null) {
			em.setMessage(ex.getCause().getMessage());
		} else {
			em.setMessage(ex.getMessage());
		}
		
		StringWriter sw = new StringWriter();
		ex.printStackTrace(new PrintWriter(sw));
		
		logger.error("[Global Exception Handler] : " + sw.toString());
		
		return em;
	}
}
