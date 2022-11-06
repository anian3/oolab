package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest {

    @Test
    void testRun(){
        //given:
        String[] args = {"f", "b", "r", "l"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        RectangularMap map = new RectangularMap(4, 4);
        Vector2d[] positions = { new Vector2d(2,1), new Vector2d(3,2) };
        IEngine engine = new SimulationEngine(directions, map, positions);

        //when:
        engine.run();

        //then:
        assertEquals(map.animals.get(0).position, new Vector2d(2, 2));
        assertEquals(map.animals.get(0).toString(), "E" );
        assertEquals(map.animals.get(1).position, new Vector2d(3, 1));
        assertEquals(map.animals.get(1).toString(), "W" );
    }

}