package com.scottbpc.texty;

public class SampleAdventure {

    public static void main(String[] args) {
        
        State deadState = new State.Builder("You died.", true).build();
        State neverAliveState = new State.Builder("You were never alive.", true).build();
        
        State winningState = new State.Builder("You have tricked the demon. Congratulations!",
            true).build();
        
        State quizState = new State.Builder("Hmm... Well then you must pass a test of wit. " +
        		"SCREAM!", false)
                .addNextState("aah!", "You scream at the top of your lungs. The beast recoils and falls. " +
                		"The sky clears... nothing is dark anymore. Go home.", winningState)
                .addNextState("", "You decide not to be the victim of the beast's game." +
                		"You crouch, silent, for fear of waking him. The figure steps up to you " +
                		"and kicks your face. Bloody and broken, you lay there and die.", deadState)
                .build();
        
        State aliveState = new State.Builder("Great! You're alive. Do you want me to fix that?", false)
            .addNextState("yes", "You nod. The beast takes a step forward, and places a finger on your lips." +
            		"You feel faint...", deadState)
            .addNextState("no", "You shrug and shake your head.", quizState)
            .build();
        
        State firstState = new State.Builder("Hello! Are you alive?", false)
            .addNextState("no", "You lie there, limp and dying. You can't move. Is this death?",
                    neverAliveState)
            .addNextState("yes", "You stumble and crawl to your knees. You slowly nod your head.",
                    aliveState)
            .build();
        
        Adventure adventure = new Adventure(firstState, "You open your eyes. Your body aches and " +
        		"your head feels numb. You see nothing but darkness. You climb to your feet and see " +
        		"a pair of eyes and a pale face.");
        adventure.play();
        
    }
}
