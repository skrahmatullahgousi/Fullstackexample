package com.quiz.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.quiz.demo.dto.Loginreqdto;
import com.quiz.demo.dto.Loginresdto;
import com.quiz.demo.dto.Registrationreqdto;
import com.quiz.demo.dto.Registrationresdto;
import com.quiz.demo.entity.Correctanswers;
import com.quiz.demo.entity.Fromscheck;
import com.quiz.demo.entity.Questions;
import com.quiz.demo.entity.Registration;
import com.quiz.demo.exceptionhandling.Usernotfoundexception;
import com.quiz.demo.repostitory.Answersrepo;
import com.quiz.demo.repostitory.Formsrepo;
import com.quiz.demo.repostitory.Optionrepo;
import com.quiz.demo.repostitory.Questionrepo;
import com.quiz.demo.repostitory.Registrationrepo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Business {
	@Autowired
	Questionrepo querepo;
	@Autowired
	Optionrepo optrepo;
	@Autowired
	Registrationrepo regisrepo;
	@Autowired
	ModelMapper mp;
	@Autowired
	JavaMailSender msgsend;
	@Autowired
	Formsrepo formrepo;
	@Autowired
	Answersrepo asrepo;

	public List<Questions> getallquestions() {
		return querepo.findAll().stream().collect(Collectors.toList());
	}

	public Questions postdata(Questions que) {
		return querepo.save(que);

	}

	public Registrationresdto Registeruser(Registrationreqdto req) {
		Registration en = mp.map(req, Registration.class);
		System.out.println(en);
		return mp.map(regisrepo.save(en), Registrationresdto.class);
	}

	public Map<String, String> loginvalidation(Loginreqdto en) {
		System.out.println(en);
		HashMap<String, String> value = new HashMap<>();
		Optional<Registration> ren = Optional.ofNullable(regisrepo.findByEmail(en.getEmail()));
		if (!ren.isEmpty()) {
			Registration val = ren.get();

			if (val.getRegisterpassword().equals(en.getRegisterPassword())) {
				value.put("message", "your are valid user");

			} else {
				value.put("message", "your password is incorrect ");
			}
		} else {
			value.put("message", "your email is not registred");
		}
		return value;
	}

	public Optional<Questions> getallquestionsbyid(int id) {
		Optional<Questions> result = querepo.findById(id);
		System.out.println(result.toString());

		if (result.isPresent()) {
			return result;
		}
		return null;

	}

	public String delete(int id) {

		Optional<Questions> res = querepo.findById(id);
		if (res.isPresent()) {
			querepo.deleteById(id);
			return "it was deleted";
		}
		return "not deleted";
	}

	public String deleteall() {
		querepo.deleteAll();
		return "it was deleted";
	}

	public Map<String, String> eamilcall(Loginresdto res, int id) throws MessagingException {

		String email = res.getEmail();
		int score = id;
		Registration result = regisrepo.findByEmail(email);
		HashMap<String, String> map = new HashMap<String, String>();
		String resulted = "";
		if (result != null) {
			try {

				MimeMessage s = msgsend.createMimeMessage();
				MimeMessageHelper h = new MimeMessageHelper(s, true);
				h.setFrom("skrahmathgousi@gmial.com");
				h.setTo(email);
				h.setSubject("Quiz Completion - Your Score");
				if (score <= 10) {
					resulted = "You're a Biggner.  Work hard";

				} else if (score > 10 && score <= 20) {
					resulted = "You're almost there.Practice more";

				} else {
					resulted = "You're a pro. Keep it up";
				}
				h.setText("Hi " + email + ",\n\n" + "Thank you for visiting us!\n\n"
						+ "Congratulations on completing the quiz! Your score is " + score + ".\n\n" + resulted + "\n"
						+ "We appreciate your participation and hope to see you again soon.\n\n" + "Best regards,\n"
						+ "The Team;");

				System.out.println(email);
				System.out.println(score);
				msgsend.send(s);
				map.put("message", "your email was sended");
			} catch (MessagingException e) {
				map.put("message", "Failed to send email: " + e.getMessage());
			}
			return map;
		}
		map.put("message", "your email was not sent");
		return map;
	}

	public Fromscheck applyingfrom(Fromscheck en) {
		return formrepo.save(en);
	}

	public void deletebyid(int id) {
		Optional<Questions> obj = querepo.findById(id);
		if (obj.isPresent()) {
			querepo.deleteById(id);

		}

	}

	public Questions updataebyid(Questions neobj, int id) throws Usernotfoundexception {
		Optional<Questions> obj = querepo.findById(id);
		if (obj.isPresent()) {
			Questions exobj = obj.get();
			exobj.setQuestion(neobj.getQuestion());
			exobj.setOption(neobj.getOption());
			querepo.save(exobj);
			return exobj;
		}
		throw new Usernotfoundexception("the id is invalid" + id, id);

	}

	public List<Questions> getRandomQuestions() {

		HashSet<Integer> lodedquestions = new HashSet<>();
		long totalquestion = querepo.count();
		System.out.println(totalquestion);
		if (lodedquestions.size() >= totalquestion) {
			lodedquestions.clear();
		}
		List<Questions> newquestion = new ArrayList<>();
		List<Questions> fetchquestions = querepo.findrandomquestions();
		for (Questions q : fetchquestions) {
			if (!lodedquestions.contains(q.getQid())) {
				newquestion.add(q);
				lodedquestions.add(q.getQid());

			}
		}

		return newquestion;

	}
//
//	public int caluclateresult(Map<Integer, Integer> userAnswers) {
//	    List<Integer> qids = new ArrayList<>(userAnswers.keySet());
//	    Map<Integer, Integer> correctAnswersMap = asrepo.fetchCorrectAnswersMap(qids);
//
//	    System.out.println("User Answers: " + userAnswers);
//	    System.out.println("Fetched Correct Answers: " + correctAnswersMap);
//
//	    int score = 0;
//	    for (Map.Entry<Integer, Integer> entry : userAnswers.entrySet()) {
//	        int qid = entry.getKey();
//	        int selectedAnswer = entry.getValue();
//
//	        System.out.println("QID: " + qid + " | User Answer: " + selectedAnswer + " | Correct Answer: " + correctAnswersMap.get(qid));
//
//	        if (correctAnswersMap.containsKey(qid) && correctAnswersMap.get(qid).equals(selectedAnswer)) {
//	            score++;
//	        }
//	    }
//
//	    System.out.println("Final Score: " + score);
//	    return score;
//	}

//	

	public void adddata(Correctanswers en) {
		asrepo.save(en);

	}

	public int finding(Map<Integer, Integer> answer) {
		int count = 0;
		List<Integer> quid = new ArrayList<>(answer.keySet());
		List<Correctanswers> corrected = asrepo.findexcat(quid);
		for (Correctanswers e : corrected) {
			if (e.getCorrectid() == answer.get(e.getQid())) {
				count++;

			}
		}
		return count;
	}

	public Questions getbyid(int id) {
		
		return querepo.getById(id);
	}

}