package com.bekdik.examer.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bekdik.examer.model.DefaultSolution;
import com.bekdik.examer.model.Solvable;

@Service("defaultSolvableProvider")
public class DeafultSolvableProvider implements SolvableProvider<String, DefaultSolution> {

	@Override
	public Collection<Solvable<String, DefaultSolution>> getSolvables() {
		
		return List.of(new Solvable<String, DefaultSolution>("soru1", new DefaultSolution("cevap1")), new Solvable<String, DefaultSolution>("soru2", new DefaultSolution("cevap2")), new Solvable<String, DefaultSolution>("soru3", new DefaultSolution("cevap3")));
	}
}
