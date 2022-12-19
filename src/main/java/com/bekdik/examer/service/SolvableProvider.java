package com.bekdik.examer.service;

import java.util.Collection;

import com.bekdik.examer.model.AbstractSolution;
import com.bekdik.examer.model.Solvable;

public interface SolvableProvider<P, S extends AbstractSolution> {
 Collection<Solvable<P, S>> getSolvables();
}
