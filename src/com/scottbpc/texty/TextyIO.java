package com.scottbpc.texty;

public interface TextyIO {

    public abstract static class in {
        
        public abstract String getResponse();
        
    }
    
    public abstract static class out {
        
        public abstract void printLine(String str);
        public abstract void printNarrationLine(String str);
    }
    
}