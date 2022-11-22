package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractWorldMapTest {

    @Test
    void testPlace() {
        //given:
        IWorldMap map = new RectangularMap(8, 8);
        Vector2d position = new Vector2d(0,0);
        String expectedMessage = "The animal can't be placed at " + position + ".";


        //when:
        try {
            Animal otter = new Animal(map, position);
            Animal weasel = new Animal(map, position);
        } catch (IllegalArgumentException exception){
            String actualMessage = exception.getMessage();
            //then:
            assertEquals(expectedMessage, actualMessage);
        }
    }

}