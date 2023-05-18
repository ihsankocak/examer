package com.bekdik.examer.service.domain.solvable;

import jakarta.persistence.Id;

import java.util.Objects;
import java.util.function.BiPredicate;

public abstract class BaseSolvable<P,S> implements Solvable {

	private long id;
protected final P problem;
protected final S solution;
private BiPredicate<S, S> answerChecker;
public BaseSolvable(long id,final P problem,final S solution, final  BiPredicate<S, S>  answerChecker){
this.problem=Objects.requireNonNull(problem);
this.solution=Objects.requireNonNull(solution);
this.answerChecker=Objects.requireNonNull(answerChecker);
this.id=id;
}

public  boolean try2Solve(S answer) {
	return answerChecker.test(answer, solution);
}

public P getProblem() {
	return problem;
}

public long getId() {
	return id;
}


}
