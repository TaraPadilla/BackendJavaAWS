package org.tarapadilla.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringUtilTest {
    @Test
    public void testRepeat3() {
        assertEquals(StringUtil.repeat("Hola",3),"HolaHolaHola");
    }

    @Test
    public void testRepeat4() {
        assertEquals(StringUtil.repeat("Hola",4),"HolaHolaHolaHola");
    }

    @Test
    public void testRepeat0() {
        assertEquals(StringUtil.repeat("Hola",0),"");
    }

    @Test
    public void testRepeatNegative() {
        assertThrows(IllegalArgumentException.class, ()->StringUtil.repeat("Hola",-3));;
    }

}