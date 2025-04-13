package com.quiz.demo.dto;

import jakarta.persistence.Column;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class Loginreqdto {

	@Column(unique = true ,nullable = false)
	String email;
	@Column(nullable = false)
	String registerPassword;

}
