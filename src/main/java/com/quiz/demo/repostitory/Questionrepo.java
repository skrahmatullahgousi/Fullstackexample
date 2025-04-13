package com.quiz.demo.repostitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quiz.demo.entity.Questions;

@Repository
public interface Questionrepo extends JpaRepository<Questions, Integer> {
	@Query(value="SELECT * FROM questions ORDER BY RAND() LIMIT 5",nativeQuery  = true)
	public List<Questions> findrandomquestions(); 
	}

