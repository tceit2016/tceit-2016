package edu.tce.it.ajax;

import java.util.HashMap;

public class UserData {

	private HashMap<String,User> users = new HashMap();

	public HashMap<String,User> getComposers() {
		return users;
	}

	public UserData() {

		users.put("1", new User("1", "Anand", "K", "Coimbatore"));
		users.put("2", new User("2", "Alwin Rex", "S", "Coimbatore"));
		users.put("3", new User("3", "Ashwin", "Rasbel", "Bangalore"));
		users.put("4", new User("4", "Henry", "S", "Madurai"));
		users.put("5", new User("5", "Jean", "R", "Madurai"));
	}
}
