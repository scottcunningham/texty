package com.scottbpc.texty;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class State {
	
	private String openingText;
	private Map<String, State> transitions;
	private Map<String, String> narrationForInputs;
	private Set<String> validInputs;
	private boolean isEndingState;
	
	private State(String openingText, boolean isEndingState) {
		this.isEndingState = isEndingState;
		this.openingText = openingText;
	}
	
	public String getNarratorText(String input) {
	    return narrationForInputs.get(input);
	}
	
	public Set<String> getValidInputs() {
		return validInputs;
	}
	
	public boolean isEndingState() {
		return this.isEndingState;
	}
	
	public String getOpeningText() {
		return this.openingText;
	}
	
	public State getNextState(String input) {
		return transitions.get(input);
	}

	public static class Builder {
	    
	    private State state;
	    
	    public Builder(String startingText, boolean isEndState) {
	        state = new State(startingText, isEndState);
	        state.narrationForInputs = new HashMap<String, String>();
	        state.transitions = new HashMap<String, State>();
	        state.validInputs = state.transitions.keySet();
	    }
	    
	    public Builder addNextState(String triggerInput, String narration, State nextState) {
	        state.narrationForInputs.put(triggerInput, narration);
	        state.transitions.put(triggerInput, nextState);
	        return this;
	    }
	
	    public State build() {
	        return state;
	    }
	}
}
