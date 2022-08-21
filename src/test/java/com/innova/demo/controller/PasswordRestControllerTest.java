package com.innova.demo.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.innova.demo.DemoApplication;
import com.innova.demo.model.BaseResponse;
import com.innova.demo.model.PasswordValidationRequest;
import com.innova.demo.utils.Constants;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PasswordRestControllerTest {

	@LocalServerPort
	private int port;
	private final static String API_PATH = "/password/validate";
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	@Test
	public void validPassword() {
		ResponseEntity<BaseResponse> response = getResponse("1qaz2wsx");
		BaseResponse repBody = response.getBody();

		assertTrue(HttpStatus.OK == response.getStatusCode());
		assertTrue(Constants.VALID_MESSAGE.equals(repBody.getMessage()));
		assertTrue(null == repBody.getErrors());
	}

	@Test
	public void inValidPasswordWithSingleError() throws JSONException {
		ResponseEntity<BaseResponse> response = getResponse("qwertyrty123");
		BaseResponse repBody = response.getBody();

		assertTrue(HttpStatus.BAD_REQUEST == response.getStatusCode());
		assertTrue(Constants.INVALID_MESSAGE.equals(repBody.getMessage()));
		assertTrue(1 == repBody.getErrors().size());
		assertTrue(repBody.getErrors().contains("password: " + Constants.SAME_SEQUENCE_FOLLOWED_MESSAGE));
	}

	@Test
	public void inValidPasswordWithMultiErrors() throws JSONException {
		ResponseEntity<BaseResponse> response = getResponse("1qaz@WSXedcedc");
		BaseResponse repBody = response.getBody();

		assertTrue(HttpStatus.BAD_REQUEST == response.getStatusCode());
		assertTrue(Constants.INVALID_MESSAGE.equals(repBody.getMessage()));
		assertTrue(3 == repBody.getErrors().size());
		assertTrue(repBody.getErrors().contains("password: " + Constants.CHAR_LENGTH_MESSAGE));
		assertTrue(repBody.getErrors().contains("password: " + Constants.CONTENT_MIXTURE_MESSAGE));
		assertTrue(repBody.getErrors().contains("password: " + Constants.SAME_SEQUENCE_FOLLOWED_MESSAGE));
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	private ResponseEntity<BaseResponse> getResponse(String testcase) {
		PasswordValidationRequest request = new PasswordValidationRequest(testcase);
		HttpEntity<PasswordValidationRequest> entity = new HttpEntity<>(request, headers);

		return restTemplate.exchange(createURLWithPort(API_PATH), HttpMethod.POST, entity, BaseResponse.class);
	}

}
