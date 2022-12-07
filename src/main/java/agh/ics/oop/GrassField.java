package agh.ics.oop;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class GrassField extends AbstractWorldMap {

    private final Map<Vector2d, Grass> grasses = new HashMap<>();
    private final int grassCount;


    private void createGrasses() {
        int max = (int) Math.sqrt(grassCount * 10);
        ArrayList<Vector2d> grassPositions = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                grassPositions.add(new Vector2d(i, j));
            }
        }
        Collections.shuffle(grassPositions);
        for (int i = 0; i < grassCount; i++) {
            grasses.put(grassPositions.get(i), new Grass(grassPositions.get(i)));
            this.mapBoundary.positionChanged(null, grassPositions.get(i));
        }
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
        return grasses.get(position) != null;
    }

    public IMapElement objectAt(Vector2d position) {
        if (animalAt(position) != null) {
            return animalAt(position);
        }
        return grasses.get(position);
    }

    public Vector2d findMapStart() {
        Vector2d MapStart = mapBoundary.getMapStart();
//        Animal animal;
        return MapStart;
    }

    public Vector2d findMapEnd() {
        return this.mapBoundary.getMapEnd();
    }
}
