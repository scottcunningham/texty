package com.scottbpc.texty;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Adventure {

    private State startingState, currentState;
	
	public Adventure(State startingState, String openingText) {
	    this.startingState = startingState;
	}
	
	public void play() {

	    currentState = startingState;

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = "";

		while (!currentState.isEndingState()) {
	    
		System.out.println("\"" + currentState.getOpeningText() + "\"");

			do {
				System.out.printf("?> ");
				try {
					input = reader.readLine();
				} catch (IOException ioe) {
					System.out.println(":(");
					System.exit(1);
				}
			}
			while (!currentState.getValidInputs().contains(input));

			System.out.println("==> " + currentState.getNarratorText(input));
			currentState = currentState.getNextState(input);
		}
		
		System.out.println("GAME OVER - play again? [y/n]");
		try {
		    input = reader.readLine();
		    
		    if (input.equals("y") || input.equals("Y")) {
		        play();
		    } else {
		        System.out.println("Goodbye!");
		    }
		    
		} catch (IOException ioe) {
		        System.out.println("Don't leave me...");
		}
	}
}
