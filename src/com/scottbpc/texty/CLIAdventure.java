package com.scottbpc.texty;

public class CLIAdventure implements TextyAdventure {

    private State startingState, currentState;
    private String openingText;
    
    public CLIAdventure(State startingState, String openingText) {
        this.startingState = startingState;
        this.openingText = openingText;
    }
    
    public void play() {

        currentState = startingState;

        TextyCLIO.out.printNarrationLine(openingText);
        
        String input;

        while (!currentState.isEndingState()) {
        
        System.out.println("\"" + currentState.getOpeningText() + "\"");

            do {
                input = TextyCLIO.in.getResponse();
            }
            while (!currentState.getValidInputs().contains(input));

            TextyCLIO.out.printNarrationLine(currentState.getNarratorText(input));
            currentState = currentState.getNextState(input);
        }
        
        System.out.println("GAME OVER - play again? [y/n]");
        
        input = TextyCLIO.in.getResponse();

        if (input.equals("y") || input.equals("Y")) {
            play();
        } else {
            System.out.println("Goodbye!");
        }
    }
}
