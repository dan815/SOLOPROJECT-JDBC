package com.fdmgroup.view;

import java.util.Scanner;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.controller.StoreController;
import com.fdmgroup.model.UserSession;

public class DashboardView {

	private Scanner scanner;
	private AuthenticationController authenticationController;
	private StoreController storeController;

	public StoreController getStoreController() {
		return storeController;
	}

	public DashboardView(Scanner scanner, AuthenticationController authenticationController) {
		super();
		this.scanner = scanner;
		this.authenticationController = authenticationController;
	}

	public void setStoreController(StoreController storeController) {
		this.storeController = storeController;
	}

	public DashboardView() {
		super();
	}

	public DashboardView(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public void showDashboard() {
		System.out.println("Welcome " + UserSession.getLoggedInUser().getFirstname() + " "
				+ UserSession.getLoggedInUser().getLastname() + "!");
		System.out.println("Please select one of the options below: ");
		System.out.println("1) Logout");
		System.out.println("2) Enter Store");
		System.out.println("3) View Inventory");
		String userInput = scanner.nextLine();

		switch (userInput) {
		case "1":
			authenticationController.logout();
			break;
		case "2":
			storeController.enterStore();
			break;
		case "3":
			authenticationController.logout();
			break;
		default:
			System.out.println("The input was invalid.");
			showDashboard();
		}
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public AuthenticationController getAuthenticationController() {
		return authenticationController;
	}

	public void setAuthenticationController(AuthenticationController authenticationController) {
		this.authenticationController = authenticationController;
	}
}
