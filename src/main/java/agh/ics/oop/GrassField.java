package agh.ics.oop;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Collections;


public class GrassField extends AbstractWorldMap {

    private ArrayList<Grass> grasses = new ArrayList<>();
    private final int grassCount;

    private void createGrasses() {
        int max = (int) Math.sqrt(grassCount * 10);
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                grasses.add(new Grass(new Vector2d(i, j)));
            }
        }
        Collections.shuffle(grasses);
        ArrayList<Grass> newGrasses = new ArrayList<>();
        for (int i = 0; i < grassCount; i++) {
            newGrasses.add(grasses.get(i));
        }
        grasses = newGrasses;
    }

    public GrassField(int grassCount) {
        this.grassCount = grassCount;
        createGrasses();
    }

    public boolean canMoveTo(Vector2d position) {

        return !isAnAnimalAt(position);
    }

    public boolean isOccupied(Vector2d position) {
        if (isAnAnimalAt(position)) {
            return true;
        }
        for (Grass grass : grasses) {
            if (grass.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public Object objectAt(Vector2d position) {
        if (animalAt(position) != null) {
            return animalAt(position);
        }
        for (Grass grass : grasses) {
            if (grass.getPosition().equals(position)) {
                return grass;
            }
        }
        return null;
    }

    public Vector2d findMapStart() {
        Vector2d mapStart = new Vector2d((int) Math.sqrt(grassCount * 10), (int) Math.sqrt(grassCount * 10));
        if (animals.size() > 0) {
            mapStart = animals.get(0).position;
            for (int i = 1; i < animals.size(); i++) {
                mapStart = mapStart.lowerLeft(animals.get(i).position);
            }
            if (mapStart.precedes(new Vector2d(0, 0))) {
                return mapStart;
            }
        }
        for (Grass grass : grasses) {
            mapStart = mapStart.lowerLeft(grass.getPosition());
        }
        return mapStart;
    }

    public Vector2d findMapEnd() {
        Vector2d mapEnd = new Vector2d(0, 0);
        if (animals.size() > 0) {
            mapEnd = animals.get(0).position;
            for (int i = 1; i < animals.size(); i++) {
                mapEnd = mapEnd.upperRight(animals.get(i).position);
            }
            if (mapEnd.follows(new Vector2d((int) Math.sqrt(grassCount * 10), (int) Math.sqrt(grassCount * 10)))) {
                return mapEnd;
            }
        }
        for (Grass grass : grasses) {
            mapEnd = mapEnd.upperRight(grass.getPosition());
        }
        return mapEnd;
    }
}
