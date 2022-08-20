package com.innova.demo.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.innova.demo.utils.Constants;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BaseResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "http status")
	private HttpStatus status;
	@Schema(description = "response messages")
	private String message;
	@Schema(description = "error details if something wrong happened")
	private List<String> errors;

	public BaseResponse() {
		this.status = HttpStatus.OK;
		this.message = Constants.VALID_MESSAGE;
	}

	public BaseResponse(HttpStatus status, String message, List<String> errors) {
		this.status = status;
		this.message = message;
		this.errors = errors;
	}

	public BaseResponse(HttpStatus status, String message, String error) {
		this.status = status;
		this.message = message;
		this.errors = Arrays.asList(error);
	}

}
