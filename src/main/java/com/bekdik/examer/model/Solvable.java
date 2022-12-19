package com.bekdik.examer.model;

public class Solvable<P,S extends AbstractSolution> {
	private final P problem;
	private final S solution;
	public Solvable(P problem, S solution) {
		super();
		this.problem = problem;
		this.solution = solution;
	}
	
public boolean answer(S solution) {
	return this.solution.equals(solution);
}

public P getProblem() {
	return problem;
}

public S getSolution() {
	return solution;
}

}
