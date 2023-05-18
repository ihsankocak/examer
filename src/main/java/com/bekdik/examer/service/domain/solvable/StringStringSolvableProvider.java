package com.bekdik.examer.service.domain.solvable;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service

public  class StringStringSolvableProvider implements SolvableProvider {
private   List<BaseSolvableWithChoosable<String, String>> solvableList;

	public StringStringSolvableProvider() {
	
	
	try(FileReader reader = new FileReader("src/main/resources/data/stringStringSolvables.json")) {
		// Parse the JSON data using GSON
        JsonElement json = new JsonParser().parse(reader);

        // Get the array of complex objects from the JSON data
        JsonArray array = json.getAsJsonObject().getAsJsonArray("questions");

        // Create a list to hold the complex objects
        List<BaseSolvableWithChoosable<String, String>> complexObjects = new ArrayList<>();


        // Iterate over the array of complex objects
        for (JsonElement element : array) {
            // Deserialize each element of the array into a complex object
        	 JsonObject object = element.getAsJsonObject();
        	 List<String> choiceList=new ArrayList<>();
        	 String solution=object.get("solution").getAsString();
        	 JsonObject choosable=object.getAsJsonObject("choosable");
        	 for(JsonElement elementChoosable:choosable.get("choices").getAsJsonArray()) {
        		 choiceList.add(elementChoosable.getAsString());
        	 }
        	 StringChoosable stringChoosable=  	new StringChoosable(choiceList, solution);
        	StringStringSolvableChoosable complexObject =new StringStringSolvableChoosable(object.get("id").getAsLong(), object.get("problem").getAsString(), solution, stringChoosable);
            // Add the complex object to the list
            complexObjects.add(complexObject);
        }
        solvableList= complexObjects;
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	@Override
	public Collection<BaseSolvableWithChoosable<String, String>> getSolvables() {
		try {
			
				if(solvableList==null) {
					String problem="Aşağıdakilerden hangisinde E harfi yoktur?";
					String solution="KA";
					Collection<String> choices=List.of("DE","FE","KA","CE");
					AbstractChoosable<String> stringChoosable=new StringChoosable(choices, solution);
					solvableList= new ArrayList<BaseSolvableWithChoosable<String, String>>();
					solvableList.add(new StringStringSolvableChoosable(1L,problem,solution,stringChoosable));
				}
			
			
		return solvableList;
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		return List.of();
		}
		
	}
}
