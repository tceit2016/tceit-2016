package edu.tce.it;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class SimpleJSONCreateExample {
     public static void main(String[] args) {

	JSONObject obj = new JSONObject();
	obj.put("name", "kumar");
	obj.put("age", new Integer(21));

	JSONArray list = new JSONArray();
	list.add("Subject 1");
	list.add("Subject 2");
	list.add("Subject 3");

	obj.put("subjects", list);

	try {

		FileWriter file = new FileWriter("d:\\test.json");
		file.write(obj.toString());
		file.flush();
		file.close();

	} catch (IOException e) {
		e.printStackTrace();
	}

	System.out.print(obj);

     }

}