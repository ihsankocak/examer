package com.bekdik.examer.service.domain.choosable;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.bekdik.examer.service.domain.solvable.StringChoosable;

public class StringChoosableTest {
@Test
	public void should_throw_exception_when_choices_notInclude_solution() {
	  assertThatExceptionOfType(Exception.class)
      .isThrownBy(() -> {
    	  new StringChoosable(List.of("ÇE", "KİR","DEK", "TE", "KER","LEK"),"RRR");
      }).withMessage("Solution could not be found in choices");
	}

@Test
public void should_not_throw_exception_when_choices_include_solution() {
	
	assertDoesNotThrow(()-> new StringChoosable(List.of("ÇE", "KİR","DEK", "TE", "KER","LEK"),"ÇE"));
	
	}

}
