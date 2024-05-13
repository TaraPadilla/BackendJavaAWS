package Mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    public void looses_when_dice_number_is_too_low() {

        //Dice dice = new Dice(6);
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(5);

        Player player = new Player(dice, 6);
        assertFalse(player.play());
    }

    @Test
    public void wins_when_dice_number_is_big() {

//        Dice dice = Mockito.mock(Dice.class);
//        Mockito.when(dice.roll()).thenReturn(4);
//
//        Player player = new Player(dice, 3);
//        assertTrue(player.play());
    }


}