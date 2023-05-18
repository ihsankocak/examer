package com.bekdik.examer.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.bekdik.examer.service.domain.solvable.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static org.springframework.boot.logging.LogLevel.ERROR;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600,methods ={RequestMethod.HEAD,RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT} )
@RestController("defaultSolvableController")
@RequestMapping("solvables")
public class SolvableController {
private Logger logger=Logger.getLogger(this.getClass().getName());
private SolvableProvider solvableProvider;
private SolvableService solvableService;

public SolvableController(SolvableProvider solvableProvider, SolvableService solvableService) {
	super();
	this.solvableProvider = solvableProvider;
	this.solvableService=solvableService;
}
public static void main(String [] args) {
	List<String> s1=new ArrayList<>();
	s1.add("a");
	s1.add("b");
	List<String> s2=new ArrayList<>(s1);
	System.out.println(s2.size());
	s2.set(0, "c");
	System.out.println(s1);
	System.out.println(s2);
}
@GetMapping
	public Collection<BaseSolvableWithChoosable<String,String>> getDefaultSolvables() {
		return solvableProvider.getSolvables();
	}

@PutMapping("{solvableId}/answer/{answer}")

public boolean answer(@PathVariable("solvableId")long solvableId,@PathVariable("answer")String answer) {

	return solvableProvider.getSolvables().stream().filter(s->s.getId()==solvableId && s.try2Solve(answer)).toList().size()==1;
}

	/* @PostMapping

	public QuestionDTO createExam(@RequestBody QuestionDTO question) {
	try{
		return solvableService.createQuestion(question);
	}catch (Exception e){
		System.out.println("create exam failed");
		e.printStackTrace();
	}
return null;

	}*/

	@PostMapping

	public Collection<QuestionDTO> createExam(@RequestBody List<QuestionDTO> questionDTOLists) {
		try{
			return solvableService.createQuestions(questionDTOLists);
		}catch (Exception e){
			System.out.println("create exam failed");
			e.printStackTrace();
		}
		return null;

	}

}
