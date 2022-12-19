package com.bekdik.examer.model;

import java.util.Objects;

public class DefaultSolution extends AbstractSolution{
	private final String solution;

	@Override
	public boolean equals(Object object) {
		// TODO Auto-generated method stub
		if(Objects.isNull(object) || !(object instanceof DefaultSolution) )
		return false;
		return ((DefaultSolution)object).solution.equals(this.solution);
	}

	public DefaultSolution(String solution) {
		super();
		this.solution = solution;
	}

	public String getSolution() {
		return solution;
	}
	

}
