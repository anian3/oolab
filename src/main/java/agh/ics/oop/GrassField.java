package agh.ics.oop;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class GrassField extends AbstractWorldMap {

    private Map<Vector2d, Grass> grasses = new HashMap<>();
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

    public Object objectAt(Vector2d position) {
        if (animalAt(position) != null) {
            return animalAt(position);
        }
        return grasses.get(position);
    }

    public Vector2d findMapStart() {
        Vector2d mapStart = new Vector2d((int) Math.sqrt(grassCount * 10), (int) Math.sqrt(grassCount * 10));
        for (Vector2d key: animals.keySet()){
            mapStart = mapStart.lowerLeft(key);
        }
        if (mapStart.precedes(new Vector2d(0,0))) {
            return mapStart;
        }
        for (Vector2d key: grasses.keySet()){
            mapStart = mapStart.lowerLeft(key);
        }
        return mapStart;
    }

    public Vector2d findMapEnd() {
        Vector2d mapEnd = new Vector2d(0, 0);
        for (Vector2d key: animals.keySet()){
            mapEnd = mapEnd.upperRight(key);
        }
        if (mapEnd.follows(new Vector2d((int) Math.sqrt(grassCount * 10), (int) Math.sqrt(grassCount * 10)))) {
            return mapEnd;
        }
        for (Vector2d key: grasses.keySet()){
            mapEnd = mapEnd.upperRight(key);
        }
        return mapEnd;
    }
}
