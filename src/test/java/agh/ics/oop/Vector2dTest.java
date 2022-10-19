package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {
    @Test
    void testEquals(){
        Vector2d vector = new Vector2d(2,1);
        Vector2d vector2 = new Vector2d(2, 1);

        boolean res = vector.equals(vector2);

        assertTrue(res);
    }

    @Test
    void testToString(){
        Vector2d vector = new Vector2d(5,4);

        String res = vector.toString();

        assertEquals("(5, 4)", res);
    }

    @Test
    void testPrecedes(){
        Vector2d vector1 = new Vector2d(2, 1);
        Vector2d vector2 = new Vector2d(2, 1);

        boolean res = vector1.precedes(vector2);

        assertTrue(res);
    }

    @Test
    void testFollows(){
        Vector2d vector1 = new Vector2d(2, 1);
        Vector2d vector2 = new Vector2d(3, 1);

        boolean res = vector1.follows(vector2);

        assertFalse(res);
    }

    @Test
    void testUpperRight(){
        Vector2d vector1 = new Vector2d(2, 2);
        Vector2d vector2 = new Vector2d(3, 1);

        Vector2d res = vector1.upperRight(vector2);

        assertEquals(new Vector2d(3, 2), res);
    }

    @Test
    void testLowerLeft(){
        Vector2d vector1 = new Vector2d(2, 2);
        Vector2d vector2 = new Vector2d(3, 1);

        Vector2d res = vector1.lowerLeft(vector2);

        assertEquals(new Vector2d(2, 1), res);
    }

    @Test
    void testAdd(){
        Vector2d vector1 = new Vector2d(2, 3);
        Vector2d vector2 = new Vector2d(1, 4);

        Vector2d res = vector1.add(vector2);

        assertEquals(new Vector2d(3, 7), res);
    }

    @Test
    void testSubstract(){
        Vector2d vector1 = new Vector2d(2, 3);
        Vector2d vector2 = new Vector2d(1, 4);

        Vector2d res = vector1.substract(vector2);

        assertEquals(new Vector2d(1, -1), res);
    }

    @Test
    void testOpposite(){
        Vector2d vector1 = new Vector2d(0, 3);

        Vector2d res = vector1.opposite();

        assertEquals(new Vector2d(0, -3), res);
    }



}