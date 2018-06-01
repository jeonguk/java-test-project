package com.jeonguk.json;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

@Slf4j
public class JsonParseTest {

	private static final String FILE_PATH = "jsonTest.json";

	public static void main(String[] args) {
		try {
			ClassLoader classLoader = JsonParseTest.class.getClassLoader();
			File file = new File(Objects.requireNonNull(classLoader.getResource(FILE_PATH)).getFile());
			// read the json file
			JSONObject jsonObject;
			try (FileReader reader = new FileReader(file)) {

				JSONParser jsonParser = new JSONParser();
				jsonObject = (JSONObject) jsonParser.parse(reader);
			}

			// get a String from the JSON object
			String firstName = (String) jsonObject.get("firstname");
			log.info("The first name is: {}", firstName);

			// get a number from the JSON object
			long id =  (long) jsonObject.get("id");
			log.info("The id is: {}", id);

			// get an array from the JSON object
			JSONArray lang= (JSONArray) jsonObject.get("languages");

			// take the elements of the json array
			for(int i=0; i<lang.size(); i++){
				log.info("The {} element of the array: {}", i, lang.get(i));
			}

			// take each value from the json array separately
			for (Object aLang : lang) {
				JSONObject innerObj = (JSONObject) aLang;
				log.info("language {} with level {} ", innerObj.get("lang"), innerObj.get("knowledge"));
			}
			// handle a structure into the json object
			JSONObject structure = (JSONObject) jsonObject.get("job");
			log.info("Into job structure, name: {}", structure.get("name"));

		} catch (IOException | ParseException | NullPointerException ex) {
			ex.printStackTrace();
		}
	}
}
