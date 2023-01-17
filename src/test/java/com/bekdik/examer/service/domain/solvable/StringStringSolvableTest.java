package com.bekdik.examer.service.domain.solvable;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;


public class StringStringSolvableTest  {

	@Test
public void testTry2Solve() {
	try {
		StringChoosable stringChoices=new StringChoosable(List.of("ÇE", "KİR","DEK", "TE", "KER","LEK"),"DEK");
		StringStringSolvableChoosable stringStringSolvable=new StringStringSolvableChoosable(1,"çek","çek",stringChoices);
		assertTrue(stringStringSolvable.try2Solve("çek"));
		assertFalse(stringStringSolvable.try2Solve("tek"));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


}
