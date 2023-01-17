package com.bekdik.examer.service.domain.solvable;

import java.util.Collection;

public interface SolvableProvider {
 Collection<BaseSolvableWithChoosable<String, String>> getSolvables();
}
