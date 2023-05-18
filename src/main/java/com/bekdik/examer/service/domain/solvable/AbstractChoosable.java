package com.bekdik.examer.service.domain.solvable;

import java.util.Collection;

public abstract class AbstractChoosable<T> {
	protected	Collection<T> choices;

	public AbstractChoosable(Collection<T> choices,T solution) throws Exception{
		if(!choices.contains(solution)) {
			throw new Exception("Solution could not be found in choices");
		}
		this.choices=choices;
	}
	public Collection<T> getChoices(){
		return choices;
	}

	public void setChoices(Collection<T> choices) {
		this.choices = choices;
	}
}
