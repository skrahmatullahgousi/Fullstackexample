package com.quiz.demo.repostitory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quiz.demo.entity.Correctanswers;

import io.lettuce.core.dynamic.annotation.Param;

@Repository
public interface Answersrepo extends JpaRepository<Correctanswers, Integer> {

//	@Query(value = "SELECT qid, correctid FROM Correctanswers WHERE qid IN (:questionIds)", nativeQuery = true)
//    List<Correctanswers> getCorrectAnswers(@Param("questionIds") List<Integer> questionIds);

//    // Convert fetched answers into a map for easy lookup
//    default Map<Integer, Integer> fetchCorrectAnswersMap(List<Integer> questionIds) {
//        List<Object[]> results = getCorrectAnswers(questionIds);
//        
//        // Debugging log
//        System.out.println("Fetched Correct Answers from DB: " + results);
//        
//        return results.stream()
//                .collect(Collectors.toMap(obj -> (Integer) obj[0], obj -> (Integer) obj[1]));
//    }


@Query(value = " SELECT ca FROM Correctanswers  ca WHERE ca.qid IN :questionid")
List<Correctanswers> findexcat(@Param ("questionid") List<Integer> questionid);
}
//
////@Query(value = "SELECT qid, correctid FROM Correctanswers WHERE qid IN (:questionIds)", nativeQuery = true)
//////@Query(value="from 	Correctanswers  as ca where  ca.qid in( = :questionIds)")
////List<Correctanswers> getCorrectAnswers(@Param("questionIds") List<Integer> questionIds);
////
////// Convert fetched answers into a map for easy lookup
////default List<Correctanswers> fetchCorrectAnswersMap(List<Integer> questionIds) {
////    List<Correctanswers> results = getCorrectAnswers(questionIds);
////    
////    // Debugging log
////    System.out.println("Fetched Correctanswers as where as. " + results);
////    
////    	//from 	Correctanswers  as ca where  ca.qid in( = :lidt)
////    return results;
////}
////}
////
//@Query(value="from 	Correctanswers  as ca where  ca.qid  = :questionIds)")
//
//Correctanswers getanswes(@Param("questionIds") int questionIds);
//	
//}