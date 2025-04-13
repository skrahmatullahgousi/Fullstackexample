package com.quiz.demo.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.demo.entity.Options;

@Repository
public interface Optionrepo extends JpaRepository<Options, Integer> {

}
