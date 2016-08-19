package com.encryption;

import java.io.*;
import java.nio.file.*;
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
		Path toBeEncryptedPath = Paths.get("\\Users\\admin\\newWorkspace\\EncryptionAssignment\\toBeEncrypted.txt");
		File toBeEncryptedFile = toBeEncryptedPath.toFile();
		Path toBeDecryptedPath = Paths.get("\\Users\\admin\\newWorkspace\\EncryptionAssignment\\toBeDecrypted.txt");
		File toBeDecryptedFile = toBeDecryptedPath.toFile();
		Path newPath = Paths.get("\\Users\\admin\\newWorkspace\\EncryptionAssignment\\newFile.txt");
		File newFile = newPath.toFile();

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
				try (BufferedReader in = new BufferedReader(new FileReader(toBeEncryptedFile))) {
					String toBeEncrypted;
					while ((toBeEncrypted = in.readLine()) != null) {
						encryptedMessage = EncryptDecrypt.encrypt(toBeEncrypted);
						System.out.println(encryptedMessage);
					}
					System.out.println();
				} catch (IOException e) {
					e.printStackTrace();
				}
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
				try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(newFile)))) {
					out.println(encryptedMessage);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case "5":
				System.out.println("Enter a message to be de-crypted.");
				userInput = sc.nextLine();
				decryptedMessage = EncryptDecrypt.decrypt(userInput);
				System.out.println(decryptedMessage);
				System.out.println();
				break;

			case "6":
				try (BufferedReader in = new BufferedReader(new FileReader(toBeDecryptedFile))) {
					String toBeDecrypted;
					while ((toBeDecrypted = in.readLine()) != null) {
						decryptedMessage = EncryptDecrypt.decrypt(toBeDecrypted);
						System.out.println(decryptedMessage);
					}
					System.out.println();
				} catch (IOException e) {
					e.printStackTrace();
				}
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
