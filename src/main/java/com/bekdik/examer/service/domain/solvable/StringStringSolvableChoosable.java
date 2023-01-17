package com.bekdik.examer.service.domain.solvable;



public class StringStringSolvableChoosable extends BaseSolvableWithChoosable<String,String>   {


public StringStringSolvableChoosable(long id,String problem,String solution,AbstractChoosable<String> choosable) throws Exception {
		super(id,problem,solution,(s1,s2)->s1.equals(s2),choosable);
		
	
}





}
