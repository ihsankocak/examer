package com.bekdik.examer.service.domain.solvable;



import java.util.Objects;
import java.util.function.BiPredicate;



public abstract class BaseSolvable<P, S> implements Solvable {

    private Long id;

    protected final P problem;
    protected final S solution;
    private final BiPredicate<S, S> answerChecker;

    public BaseSolvable(Long id, final P problem, final S solution, final BiPredicate<S, S> answerChecker) {
        this.problem = Objects.requireNonNull(problem);
        this.solution = Objects.requireNonNull(solution);
        this.answerChecker = Objects.requireNonNull(answerChecker);
        this.id = id;
    }

    public boolean try2Solve(S answer) {
        return answerChecker.test(answer, solution);
    }


}
