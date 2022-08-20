package com.innova.demo.validate.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class SameSequenceFollowedValidatorTest {

	private SameSequenceFollowedValidator validator = new SameSequenceFollowedValidator();

	@Nested
	class ValidFlow {
		@Test
		void shouldReturnTrue() {
			assertTrue(isValid(null));
			assertTrue(isValid(""));
			assertTrue(isValid("1qaz2wsx"));
			assertTrue(isValid("awsdef3defrtg"));
		}
	}

	@Nested
	class InvalidFlow {
		@Test
		void ishouldReturnFalse() {
			assertFalse(isValid("1qaz1qaz"));
			assertFalse(isValid("awsdefdefrtg"));
			assertFalse(isValid("aqwsedrfgrfg"));
		}
	}

	private boolean isValid(String value) {
		return validator.isValid(value, null);
	}

}