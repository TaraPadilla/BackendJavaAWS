package org.tarapadilla.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void no_es_vacio() {
        String variable = "x";
        assertFalse(StringUtil.isEmpty(variable));
    }
    @Test
    public void null_es_vacio() {
        String variable = null;
        assertTrue(StringUtil.isEmpty(variable));
    }
    @Test
    public void con_espacios() {
        String variable = " ";
        assertTrue(StringUtil.isEmpty(variable));
    }
}