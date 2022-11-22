package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void testParse() {
        //given:
        String[] arguments = {"f", "forward", "backward", "r", "rat"};
        String expectedMessage = "\"" + arguments[4] + "\" is not legal move specification. You can use one of the following: f, b, r, l.";

        //when
        try {
            MoveDirection[] result = OptionsParser.parse(arguments);
        } catch(IllegalArgumentException exception){
            String actualMessage = exception.getMessage();
            //then:
            assertEquals(expectedMessage, actualMessage);
        }
    }

}