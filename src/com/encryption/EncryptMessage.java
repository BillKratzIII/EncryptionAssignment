package com.encryption;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class EncryptMessage {

	public static void main(String[] args) {
		// declare variables
		boolean correctInput = true;
		boolean contApp = true;
		String menuInput = null;
		String userInput = null;
		String encryptedMessage = null;
		String decryptedMessage = null;
		Scanner sc = new Scanner(System.in);

		// do while loop to keep program running until users asks to exit
		do {
			// do while loop to prompt user to make a menu selection until a
			// valid selection is received
			do {
				EncryptDecrypt.printOptions();
				menuInput = sc.nextLine();

				correctInput = com.utils.Validator.userInputForMenu(menuInput, correctInput);

			} while (correctInput);

			// switch statement to call methods based on user input
			switch (menuInput) {
			case "1":
				System.out.println("Enter a message to be encrypted.");
				userInput = sc.nextLine();
				encryptedMessage = EncryptDecrypt.encrypt(userInput);
				System.out.println("Your message had been encrypted.\n");
				System.out.println();
				break;
			case "2":
				// encrypt to from file
				break;

			case "3":
				if (encryptedMessage != null) {
					System.out.println(encryptedMessage + "\n");
				} else {
					System.out.println("No message found, please enter a message first.\n");
					System.out.println();
				}

				break;

			case "4":
				// save to file
				break;

			case "5":
				System.out.println("Enter a message to be de-crypted.");
				userInput = sc.nextLine();
				decryptedMessage = EncryptDecrypt.decrypt(userInput);
				System.out.println(decryptedMessage);
				System.out.println();
				break;

			case "6":
				// decrypt from file
				break;

			case "7":
				System.out.println("Thank you for using the program. Goodbye!");
				contApp = false;
				break;

			case "99":
				if (encryptedMessage != null) {
					decryptedMessage = EncryptDecrypt.decrypt(encryptedMessage);
					System.out.println(decryptedMessage);
					System.out.println();
				} else {
					System.out.println("No message found, please enter a message first.\n");
					System.out.println();
				}
				break;
			}// switch
		} while (contApp);

		sc.close();
	}// main

}// class
