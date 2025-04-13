package com.quiz.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor
@AllArgsConstructor

public class Correctanswers {
	@Id
	 @Column(name = "qid", nullable = false)
	int qid;
	int correctid;

}
