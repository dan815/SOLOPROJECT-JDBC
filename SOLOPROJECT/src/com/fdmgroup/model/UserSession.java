package com.fdmgroup.model;

public class UserSession {

	private static User loggedInUser;

	public static User getLoggedInUser() {
		return loggedInUser;
	}

	public static void setLoggedInUser(User loggedInUser) {
		UserSession.loggedInUser = loggedInUser;
	}
}
