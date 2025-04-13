package com.quiz.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int regid;
	String registerName;
	@Column(nullable = false,length = 8)
	String registerpassword;
	@Column(unique = true,nullable = false)
	String email;

}
