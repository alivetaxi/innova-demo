package com.innova.demo.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.innova.demo.model.BaseResponse;
import com.innova.demo.utils.Constants;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = new ArrayList<String>();

		for (FieldError error : ex.getBindingResult().getFieldErrors())
			errors.add(error.getField() + ": " + error.getDefaultMessage());

		for (ObjectError error : ex.getBindingResult().getGlobalErrors())
			errors.add(error.getObjectName() + ": " + error.getDefaultMessage());

		BaseResponse baseResponse = new BaseResponse(HttpStatus.BAD_REQUEST, Constants.INVALID_MESSAGE, errors);
		return handleExceptionInternal(ex, baseResponse, headers, baseResponse.getStatus(), request);
	}

}