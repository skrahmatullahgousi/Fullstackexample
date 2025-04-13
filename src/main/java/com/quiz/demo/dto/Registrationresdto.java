package com.quiz.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registrationresdto {
	int Registraionid;
	String RegisterName;
	String Registerpassword;
	String email;
}
