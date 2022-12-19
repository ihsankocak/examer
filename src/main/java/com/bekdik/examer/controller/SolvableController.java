package com.bekdik.examer.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bekdik.examer.model.DefaultSolution;
import com.bekdik.examer.model.Solvable;
import com.bekdik.examer.service.SolvableProvider;

@RestController
@RequestMapping("solvables")
public class SolvableController {

private SolvableProvider<String, DefaultSolution> solvableProvider;

	public SolvableController(@Qualifier("defaultSolvableProvider")SolvableProvider<String, DefaultSolution> solvableProvider) {
	super();
	this.solvableProvider = solvableProvider;
}

@GetMapping("")
	public Collection<Solvable<String, DefaultSolution>> getDefaultSolvables() {
		System.out.println("INGETSERVICEE");
		return solvableProvider.getSolvables();
	}
}
