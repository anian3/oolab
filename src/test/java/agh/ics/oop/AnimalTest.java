package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void testMove(){
        //given:
        IWorldMap map = new RectangularMap(4, 4);
        Animal rat = new Animal(map, new Vector2d(0,0));
        Animal bunny = new Animal(map, new Vector2d(0,0));

        //when:
        rat.move(MoveDirection.RIGHT);
        rat.move(MoveDirection.BACKWARD);
        for (int i = 0; i<10; i++) {
            bunny.move(MoveDirection.FORWARD);
        }

        //then:
        assertEquals(rat.toString(), "(1, 2) Wschód");
        assertEquals(bunny.toString(), "(2, 4) Północ");
    }

}