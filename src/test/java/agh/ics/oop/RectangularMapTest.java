package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class RectangularMapTest {

    @Test
    void testCanMoveTo(){
        //given:
        IWorldMap map = new RectangularMap(8, 8);
        Vector2d position1 = new Vector2d(3,0);
        Vector2d position2 = new Vector2d(-1,0);
        Vector2d position3 = new Vector2d(4,6);
        Animal iguana = new Animal(map, position1);


        //when:
        map.place(iguana);

        //then:
        assertFalse(map.canMoveTo(position1));
        assertFalse(map.canMoveTo(position2));
        assertTrue(map.canMoveTo(position3));
    }

}