package com.bekdik.examer.controller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bekdik.examer.service.domain.solvable.AbstractChoosable;
import com.bekdik.examer.service.domain.solvable.StringChoosable;
import com.bekdik.examer.service.domain.solvable.StringStringSolvableChoosable;

@SpringBootTest
public class SolvableControllerTest {

private SolvableController solvableController;
public SolvableControllerTest(@Autowired SolvableController solvableController) {
	this.solvableController=solvableController;
}

@Test
public void testIfAnswerCorrect() {
	final String correctAnswer="test cevabı";
	final String wrongAnswer="yanlış test cevabı";
	StringStringSolvableChoosable stringSolvableChoosable;
	try {
		stringSolvableChoosable = new StringStringSolvableChoosable(100, "test sorusu", correctAnswer, new StringChoosable(List.of(correctAnswer,"başka test seçeneği"), "test cevabı"));
		solvableController.getDefaultSolvables().add(stringSolvableChoosable);
		assertTrue(solvableController.answer(stringSolvableChoosable.getId(),correctAnswer));
		assertFalse(solvableController.answer(stringSolvableChoosable.getId(),wrongAnswer));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

}
