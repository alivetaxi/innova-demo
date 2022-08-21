package com.innova.demo.model;

import java.io.Serializable;

import com.innova.demo.validate.CharLength;
import com.innova.demo.validate.ContentMixture;
import com.innova.demo.validate.SameSequenceFollowed;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordValidationRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@ContentMixture
	@CharLength
	@SameSequenceFollowed
	@Schema(description = "the password string to verify")
	private String password;
}
