package com.gowpar.json.java;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PersonJsonEncodeDemo {

	public static void main(String[] args) {
		
		// https://www.mkyong.com/java/jackson-2-convert-java-object-to-from-json/

		Person person = new Person();

		person.setFirstName("Naruto");
		;
		person.setMiddleName("Shinobi");
		person.setLastName("Uzumaki");

		ObjectMapper mapper = new ObjectMapper();
		try {
			// Convert object to JSON string and save into a file directly
			mapper.writeValue(new File("person.json"), person);

			// Convert object to JSON string
			String jsonInString = mapper.writeValueAsString(person);
			System.out.println(jsonInString);

			// Convert object to JSON string and pretty print
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
			System.out.println(jsonInString);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
