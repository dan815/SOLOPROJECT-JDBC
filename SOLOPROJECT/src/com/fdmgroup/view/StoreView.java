package com.fdmgroup.view;

import java.util.Scanner;

import com.fdmgroup.controller.StoreController;
import com.fdmgroup.model.UserSession;

public class StoreView {
	private Scanner scanner;
	private StoreController storeController;
	
	public StoreView(Scanner scanner) {
		super();
		this.scanner=scanner;
	}

	public StoreView(Scanner scanner, StoreController storeController) {
		super();
		this.scanner = scanner;
		this.storeController = storeController;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public StoreController getStoreController() {
		return storeController;
	}

	public void setStoreController(StoreController storeController) {
		this.storeController = storeController;
	}

	public void enterStore() {
		System.out.println("Watchu need " + UserSession.getLoggedInUser().getFirstname() + " "
				+ UserSession.getLoggedInUser().getLastname() + "!");
		storeController.displayCards();
		
		System.out.println("Please select one of the options below: ");
		System.out.println("1) Exit Store");
		System.out.println("2) Buy Card");
		System.out.println("3) Sell Card");
		String userInput = scanner.nextLine();

		switch (userInput) {
		case "1":
			System.out.println("Come back soon, ya hear!");
			storeController.exitStore();
			break;
		case "2":
			System.out.println("Enter Card ID to buy: ");
			int cardID = scanner.nextInt();
			storeController.buyCard(cardID,UserSession.getLoggedInUser().getId());
			break;
		case "3":

			break;
		default:
			System.out.println("The input was invalid.");
			enterStore();

		}

	}
}
