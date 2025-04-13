package com.quiz.demo.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.demo.entity.Registration;

@Repository
public interface Registrationrepo extends JpaRepository<Registration, Integer> {
	Registration findByEmail(String  email);
}
