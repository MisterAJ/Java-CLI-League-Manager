package com.teamtreehouse.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Prompter {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String prompt(String promptString) {
		System.out.println(promptString);
        String input;
        try {
            input = br.readLine();
        }catch (IOException ioe) {
            throw new IllegalArgumentException("Hmm, That doesn't seem to fit", ioe);
        }
            return input;
	}

	static boolean promptForBoolean(String promptString){
        boolean bool;
        String input;
        System.out.println(promptString);
        try {
            input = br.readLine();
        }catch (IOException ioe) {
            throw new IllegalArgumentException("Hmm, That doesn't seem to fit", ioe);
        }
        bool = Objects.equals(input.toLowerCase(), "y");
        return bool;
	}

}