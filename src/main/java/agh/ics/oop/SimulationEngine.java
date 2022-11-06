package agh.ics.oop;

public class SimulationEngine implements IEngine {

    private MoveDirection[] directions;
    private RectangularMap map;


    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions) {
        this.directions = directions;
        this.map = (RectangularMap) map;
        for (Vector2d position: positions){
            Animal currentAnimal = new Animal(this.map, position);
            this.map.place(currentAnimal);
        }
    }

    public void run() {
        int animalsCount = map.animals.size();
        for (int i = 0; i < directions.length; i++) {
            map.animals.get(i % animalsCount).move(directions[i]);
        }
    }

}
