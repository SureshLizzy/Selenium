package com.java.practice;

public class SubString {

	public static void main(String[] args) {
        String inputString = "Selenium Automation";

        // Find the index of "Auto" in the input string
        int startIndex = inputString.indexOf("Auto");
        System.out.println(startIndex);

        // Check if "Auto" is present in the string
        if (startIndex != -1) {
            // Extract the substring starting from the index of "Auto"
            String output = inputString.substring(startIndex, startIndex + 4);
            System.out.println("Output: " + output);
        } else {
            System.out.println("Substring not found in the input string.");
        }
    }

}
