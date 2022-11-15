package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine {

    private MoveDirection[] directions;
    private ArrayList<Animal> animals = new ArrayList<>();


    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions) {
        this.directions = directions;
        for (Vector2d position: positions){
            Animal currentAnimal = new Animal(map, position);
            if (map.place(currentAnimal)){
                animals.add(currentAnimal);
            }
        }
    }

    public void run() {
        int animalsCount = animals.size();
        for (int i = 0; i < directions.length; i++) {
            animals.get(i % animalsCount).move(directions[i]);
        }
    }
}
