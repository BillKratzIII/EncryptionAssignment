package com.utils;

public class Validator {

	// method to ensure the user enters a valid menu selection
	public static boolean userInputForMenu(String menuInput, boolean correctInput) {
		switch (menuInput) {
		case "1":
			correctInput = false;
			break;

		case "2":
			correctInput = false;
			break;

		case "3":
			correctInput = false;
			break;

		case "4":
			correctInput = false;
			break;

		case "5":
			correctInput = false;
			break;

		case "6":
			correctInput = false;
			break;

		case "7":
			correctInput = false;
			break;

		case "99":
			correctInput = false;
			break;

		default:
			System.out.println("Not a valid option, must enter a number 1-7. Please try again.\n");
			break;
		}
		return correctInput;
	}// userInputForMenu()
}
