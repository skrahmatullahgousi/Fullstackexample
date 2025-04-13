package com.quiz.demo.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Options implements Serializable {
	private  static final long seriealVersionUID=1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int optionid;
	String options;
	
	

}
