package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine, Runnable {

    private final MoveDirection[] directions;

    public final IWorldMap map;
    
    private ArrayList<Vector2d> positions = new ArrayList<>();
//    private int currentIndex;


    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions) {
        this.directions = directions;
        this.map = map;
        for (Vector2d position: positions){
            Animal currentAnimal = new Animal(map, position);
            if(currentAnimal.map != null) {this.positions.add(position);}
        }
//        currentIndex = 0;
    }

//    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
//        if (oldPosition != null){
//            int index = positions.indexOf(oldPosition);
//            positions.set(index, newPosition);
//        }
//    }

    public void run() {
        int animalsCount = positions.size();
        Animal animal;
        for (int i = 0; i < directions.length; i++) {
            animal = map.animals.get(positions.get(i % animalsCount));
            animal.move(directions[i]);
            positions.set(i % animalsCount, animal.getPosition());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException("Przerwano symulację.");
            }
        }
    }
    }

