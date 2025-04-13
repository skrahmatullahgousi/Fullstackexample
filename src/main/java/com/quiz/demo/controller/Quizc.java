package com.quiz.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.demo.dto.Loginreqdto;
import com.quiz.demo.dto.Loginresdto;
import com.quiz.demo.dto.Registrationreqdto;
import com.quiz.demo.dto.Registrationresdto;
import com.quiz.demo.entity.Correctanswers;
import com.quiz.demo.entity.Fromscheck;
import com.quiz.demo.entity.Questions;
import com.quiz.demo.service.Business;

import jakarta.mail.MessagingException;

@CrossOrigin
@RestController
@RequestMapping
public class Quizc {

	@Autowired
	Business sobj;


	@PostMapping("/postdata")
	public Questions postquestion(@RequestBody Questions que) {
		return sobj.postdata(que);
	}

	@GetMapping("/getquestions")
	public List<Questions> gertallquestions() {
		return sobj.getallquestions();
	}

	@GetMapping("/getquestion/{id}")
	public Optional<Questions> gertallquestionsbyid(@PathVariable int id) {
		return sobj.getallquestionsbyid(id);
	}

	@PostMapping("/register")
	public Registrationresdto postregisterdetails(@RequestBody Registrationreqdto register) {
		return sobj.Registeruser(register);
	}

	@PostMapping("/login")
	public Map<String, String> postlogindetails(@RequestBody Loginreqdto login) {
		return sobj.loginvalidation(login);
	}

	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable int id) {
		return sobj.delete(id);
	}

	@DeleteMapping("delete")
	public String delete() {
		return sobj.deleteall();
	}

	@PostMapping("/email/{id}")
	public Map<String, String> sending(@RequestBody Loginresdto res, @PathVariable int id) throws MessagingException {
		return sobj.eamilcall(res, id);
	}

	@PostMapping("/from")
	public Fromscheck postdata(@RequestBody Fromscheck en) {
		return sobj.applyingfrom(en);
	}

	@PutMapping("path/{id}")
	public Questions updataebyid(@RequestBody Questions neobj, @PathVariable int id) {
		return sobj.updataebyid(neobj, id);
	}

	@GetMapping("/getquestion")
	public List<Questions> randomquestions() {
		return sobj.getRandomQuestions();
	}

	@PostMapping("/caluclatedscore")
	public int getscore(@RequestBody Map<Integer, Integer> en) {
		return sobj.finding(en);
	}
	

	 @GetMapping("/getbyid/{id}")
	 public Questions getid(@PathVariable int id) {
		 return sobj.getbyid(id);
	 }
	 
	@PostMapping("/adddatatoanswer")
	public void adddat(@RequestBody Correctanswers en) {
		sobj.adddata(en);
	}
}
