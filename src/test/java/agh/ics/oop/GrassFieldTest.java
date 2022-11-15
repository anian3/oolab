package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void testPlace(){
        //given:
        IWorldMap map = new GrassField(8);
        Vector2d position1 = new Vector2d(2, 30);
        Animal pikachu = new Animal(map, position1);
        Animal raichu = new Animal(map, position1);
        boolean res1;
        boolean res2;

        //when:
        res1 = map.place(pikachu);
        res2 = map.place(raichu);

        //then:
        assertTrue(res1);
        assertFalse(res2);
    }

    @Test
    void testObjectAt(){
        //given:
        IWorldMap map = new GrassField(10);
        Vector2d position1 = new Vector2d(2, 3);
        Vector2d position2 = new Vector2d(200, 200);
        Animal togepi = new Animal(map, position1);

        //when:
        map.place(togepi);

        //then:
        assertEquals(map.objectAt(position1), togepi);
        assertNull(map.objectAt(position2));
    }

}