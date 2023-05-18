package com.bekdik.examer.service.domain.solvable;

import java.util.Objects;
import java.util.function.BiPredicate;

public abstract class BaseSolvableWithChoosable<P,S> extends BaseSolvable<P,S> {
private AbstractChoosable<S> choosable;

public BaseSolvableWithChoosable(long id,final P problem,final S solution, final  BiPredicate<S, S>  answerChecker,AbstractChoosable<S> choosable) {
	super(id, problem, solution,   answerChecker);

this.choosable=Objects.requireNonNull(choosable);;
}

public AbstractChoosable<S> getChoosable() {
	return choosable;
}

	public void setChoosable(AbstractChoosable<S> choosable) {
		this.choosable = choosable;
	}
}
