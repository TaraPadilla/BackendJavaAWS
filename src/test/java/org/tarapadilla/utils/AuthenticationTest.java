package org.tarapadilla.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.tarapadilla.utils.Authentication.SecurityLevel.*;

public class AuthenticationTest {

    @Test
    public void weak_when_has_less_than_8() {
       assertEquals(WEAK, Authentication.validateNewPass("12378"));
    }

    @Test
    public void medium_when_has_lett_and_num() {
        assertEquals(MEDIUM, Authentication.validateNewPass("123EER78"));
    }

    @Test
    public void isStrong() {
        assertEquals(STRONG, Authentication.validateNewPass("13EER7#78"));
    }
}