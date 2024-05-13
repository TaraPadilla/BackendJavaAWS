package org.tarapadilla.utils;

public class StringUtil {

    public static String repeat(String palabra, int numero){
        String result ="";
        if (numero<0){throw new IllegalArgumentException("Negative times not allowed");}
        for (int i = 0; i < numero; i++) {
            result += palabra;
     }
        return result;
    }
}
