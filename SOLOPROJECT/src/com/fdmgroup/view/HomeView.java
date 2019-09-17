package com.fdmgroup.view;

import java.util.Scanner;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.controller.HomeController;

public class HomeView {

	private Scanner scanner;
	private HomeController homeController;
	private AuthenticationController authenticationController;
	
	public HomeView() {
		super();
	}
	
	public HomeView(Scanner scanner) {
		super();
		this.scanner = scanner;
	}
	
	public HomeView(Scanner scanner, HomeController homeController, AuthenticationController authenticationController) {
		super();
		this.scanner = scanner;
		this.homeController = homeController;
		this.authenticationController = authenticationController;
	}

	public void showInitialOptions(boolean showLogoutMessage) {
		if (showLogoutMessage) {
			System.out.println("You logged out successfully.");
		}
		
		System.out.println("Welcome to my Solo Project Version 1.0.0");
		System.out.println("Please choose one of the options below:");
		System.out.println("1) Login");
		System.out.println("2) Register");
		System.out.println("3) Exit");
		System.out.println("-------------------------------");
		String userInput = scanner.nextLine();
		
		switch (userInput) {
		case "1":
			showLoginOptions(false);
			break;
		case "2":
			showRegisterOptions(false);
			
			break;
		case "3":
			System.out.println("Thanks, Goodbye!");
			System.exit(0);
			break;
		default:
			System.out.println("The input is invalid.");
			showInitialOptions(false);
		}
	}

	public void showRegisterOptions(boolean showError) {
		if (showError){
			System.out.println("Invalid registration, try again.");
		}
		System.out.println("Enter your first name: ");
		String firstName = scanner.nextLine();
		System.out.println("Enter your last name: ");
		String lastName = scanner.nextLine();
		System.out.println("Enter your user name: ");
		String username = scanner.nextLine();
		System.out.println("Enter your user password ");
		String password = scanner.nextLine();
		
		authenticationController.register(firstName, lastName, username, password);
		// TODO Auto-generated method stub
	}

	public void showLoginOptions(boolean showError) {
		if (showError) {
			System.out.println("Username/Password is wrong.");
		}
		
		System.out.println("Login");
		System.out.println("Please enter username: ");
		String username = scanner.nextLine();
		System.out.println("Please enter password: ");
		String password = scanner.nextLine();
		
		//TODO add validation here
		
		authenticationController.login(username, password);
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public HomeController getHomeController() {
		return homeController;
	}

	public void setHomeController(HomeController homeController) {
		this.homeController = homeController;
	}

	public AuthenticationController getAuthenticationController() {
		return authenticationController;
	}

	public void setAuthenticationController(AuthenticationController authenticationController) {
		this.authenticationController = authenticationController;
	}
}




















