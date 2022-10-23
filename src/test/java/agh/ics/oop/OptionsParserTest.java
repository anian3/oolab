package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void testParse() {
        //given:
        String[] arguments = {"f", "forward", "backward", "r", "rat"};

        //when
        MoveDirection[] result = OptionsParser.parse(arguments);

        //then:
        MoveDirection[] expectedResult = new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT};
        assertArrayEquals(result, expectedResult);
    }

}