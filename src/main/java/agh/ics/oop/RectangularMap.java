package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap implements IWorldMap {

    protected ArrayList<Animal> animals;
    private Vector2d mapEnd;
    private final Vector2d mapStart = new Vector2d(0, 0);

    public RectangularMap(int width, int height) {
        if (width > 0 && height > 0) {
            animals = new ArrayList<>();
            mapEnd = new Vector2d(width-1, height-1);
        }
    }




    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position)) {
                return true;
            }
        }
        return false;
    }

    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) && position.precedes(mapEnd) && position.follows(mapStart);
    }

    public boolean place(Animal animal) {
        if (canMoveTo(animal.position)) {
            animals.add(animal);
            return true;
        }
        return false;
    }

    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position)) {
                return animal;
            }
        }
        return null;
    }

    public String toString() {
        MapVisualiser map = new MapVisualiser(this);
        return map.draw(mapStart, mapEnd);
    }


}
