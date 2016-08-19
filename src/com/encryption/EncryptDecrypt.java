package com.encryption;

public class EncryptDecrypt {

	// method to print menu options
	public static void printOptions() {
		System.out.println("What would you like to do?");
		System.out.println("1 - encrypt an entered message");
		System.out.println("2 - encrypt a message from text file");
		System.out.println("3 - show encrypted message");
		System.out.println("4 - save encrypted message to text file");
		System.out.println("5 - decrypt an entered message");
		System.out.println("6 - decrypt a message from text file");
		System.out.println("7 - exit program");
	}// printOptions()

	// method to take in a regular String and return an encrypted String
	public static String encrypt(String messageToBeEncrypted) {
		int SHIFT = (int) (Math.random() * 10) + 1; // sets shift for the
													// encryption to a random
													// number between 0-10
		String steppedMessage = null;
		String encryptedMessage = null;
		StringBuilder sb = new StringBuilder(messageToBeEncrypted);
		StringBuilder sb2 = new StringBuilder();

		// for loop fills empty string builder with chars that have been shifted
		for (int i = 0; i < sb.length(); i++) {
			char temp = sb.charAt(i);
			int temp2 = temp + SHIFT;
			char temp3 = (char) temp2;
			sb2.append(temp3);
		}
		// add key to the end of the shifted message
		sb2.append(SHIFT);
		steppedMessage = sb2.toString();

		// encodes to Base64 and reverses
		encryptedMessage = new StringBuffer(steppedMessage).reverse().toString();

		// clear string builders
		sb.setLength(0);
		sb2.setLength(0);

		return encryptedMessage;
	}// encrypt()

	// method to take in a encrypted string and return the original message
	public static String decrypt(String encryptedMessage) {
		int SHIFT;
		char tempChar;
		String decryptedMessage = null;
		String tempString;
		StringBuilder sbb2 = new StringBuilder();

		// reverses and decodes to plain text
		String shiftedMessage = new StringBuffer(encryptedMessage.toString()).reverse().toString();

		// reverses shift back to original message
		StringBuilder sbb = new StringBuilder(shiftedMessage);
		tempChar = (sbb.charAt((sbb.length() - 1)));
		tempString = Character.toString(tempChar);
		SHIFT = Integer.parseInt(tempString);
		sbb.deleteCharAt((sbb.length() - 1));
		for (int i = 0; i < sbb.length(); i++) {
			char temp = sbb.charAt(i);
			int temp2 = temp - SHIFT;
			char temp3 = (char) temp2;
			sbb2.append(temp3);
		}
		decryptedMessage = sbb2.toString();

		// clear string builders
		sbb.setLength(0);
		sbb2.setLength(0);

		return decryptedMessage;
	}// decrypt()

}// class
