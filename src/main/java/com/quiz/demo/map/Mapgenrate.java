package com.quiz.demo.map;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapgenrate {
	@Bean
	 ModelMapper createmap() {
		return new ModelMapper();
	}

}
