package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {
    @Test
    void testNext() {

        MapDirection map1 = MapDirection.EAST;
        MapDirection map2 = MapDirection.SOUTH;
        MapDirection map3 = MapDirection.WEST;
        MapDirection map4 = MapDirection.NORTH;

        MapDirection res1 = map1.next();
        MapDirection res2 = map2.next();
        MapDirection res3 = map3.next();
        MapDirection res4 = map4.next();

        assertEquals(MapDirection.SOUTH, res1);
        assertEquals(MapDirection.WEST, res2);
        assertEquals(MapDirection.NORTH, res3);
        assertEquals(MapDirection.EAST, res4);
    }

    @Test
    void testPrevious(){

        MapDirection map1 = MapDirection.EAST;
        MapDirection map2 = MapDirection.SOUTH;
        MapDirection map3 = MapDirection.WEST;
        MapDirection map4 = MapDirection.NORTH;

        MapDirection res1 = map1.previous();
        MapDirection res2 = map2.previous();
        MapDirection res3 = map3.previous();
        MapDirection res4 = map4.previous();

        assertEquals(MapDirection.NORTH, res1);
        assertEquals(MapDirection.EAST, res2);
        assertEquals(MapDirection.SOUTH, res3);
        assertEquals(MapDirection.WEST, res4);
    }
}