package com.quiz.demo.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.demo.entity.Fromscheck;

@Repository
public interface Formsrepo  extends JpaRepository<Fromscheck, Integer>{
	

}
