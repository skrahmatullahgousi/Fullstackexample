package com.quiz.demo.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registrationreqdto {
	@Column(nullable = false)
	String RegisterName;
	@Column(unique = true, nullable = false)
	@Size(min = 8)
	String Registerpassword;
	@Column(unique = true, nullable = false)
	String email;
}
