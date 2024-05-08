package org.tarapadilla.utils;



class Authentication {

    public static enum SecurityLevel {
        WEAK, MEDIUM, STRONG, VERY_STRONG
    }

    public static SecurityLevel validateNewPass(String pass){
        if (pass.length() < 8){
        return SecurityLevel.WEAK;
        }

        if (pass.matches("[0-9]+")) {
            return SecurityLevel.WEAK;
        }

        if (pass.matches("[a-zA-Z]+")) {
            return SecurityLevel.WEAK;
        }

        if (pass.matches("[a-zA-Z0-9]+")) {
            return SecurityLevel.MEDIUM;
        }

        return SecurityLevel.STRONG;
    }
}
