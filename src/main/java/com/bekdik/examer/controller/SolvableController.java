package com.bekdik.examer.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bekdik.examer.service.domain.solvable.BaseSolvableWithChoosable;
import com.bekdik.examer.service.domain.solvable.SolvableProvider;
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController("defaultSolvableController")
@RequestMapping("solvables")
public class SolvableController {

private SolvableProvider solvableProvider;

public SolvableController(@Qualifier("defaultSolvableProvider")SolvableProvider solvableProvider) {
	super();
	this.solvableProvider = solvableProvider;
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
@GetMapping("")

	public Collection<BaseSolvableWithChoosable<String,String>> getDefaultSolvables() {
		System.out.println("INGETSERVICEE");
		return solvableProvider.getSolvables();
	}

@GetMapping("{solvableId}/answer/{answer}")

public boolean answer(@PathVariable("solvableId")long solvableId,@PathVariable("answer")String answer) {
	System.out.println("INGETSERVICEE");
	return solvableProvider.getSolvables().stream().filter(s->s.getId()==solvableId && s.try2Solve(answer)).collect(Collectors.toList()).size()==1;
}
}
