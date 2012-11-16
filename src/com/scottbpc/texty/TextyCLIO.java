package com.scottbpc.texty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextyCLIO implements TextyIO {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    public static class in {

        public static String getResponse() {
            System.out.println("?> ");
            String input = "";
            try {
                input = reader.readLine();
            } catch (IOException ioe) {
                System.out.println(":(");
                System.exit(1);
            }
            return input;
        }
        
    }
    
    public static class out {

        public static void printLine(String str) {
            System.out.println(str);
        }

        public static void printNarrationLine(String str) {
            System.out.println("==> " + str);
        }
    }

}
