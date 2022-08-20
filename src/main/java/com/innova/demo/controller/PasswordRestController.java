package com.innova.demo.controller;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innova.demo.model.BaseResponse;
import com.innova.demo.model.PasswordValidationRequest;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "/password", produces = MediaType.APPLICATION_JSON_VALUE)
public class PasswordRestController {

	@PostMapping(path = "/validate")
	@Operation(summary = "password validation service")
	public BaseResponse validate(@Valid @RequestBody PasswordValidationRequest request) {
		return new BaseResponse();
	}

}
