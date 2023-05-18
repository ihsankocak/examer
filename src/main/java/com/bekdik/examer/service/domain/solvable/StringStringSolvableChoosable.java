package com.bekdik.examer.service.domain.solvable;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;
public class StringStringSolvableChoosable extends BaseSolvableWithChoosable<String,String>   {

public StringStringSolvableChoosable(long id,String problem,String solution,AbstractChoosable<String> choosable) throws Exception {
		super(id,problem,solution,(s1,s2)->s1.equals(s2),choosable);
		
	
}

public static StringStringSolvableChoosable getDummyStringStringSolvableChoosable() throws Exception {
	final String correctAnswer="test cevabı";
	final String wrongAnswer="yanlış test cevabı";
	return new StringStringSolvableChoosable(100, "test sorusu", correctAnswer, new StringChoosable(List.of(correctAnswer,"başka test seçeneği"), "test cevabı"));
}
}
