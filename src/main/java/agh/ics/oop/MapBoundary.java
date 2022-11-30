package agh.ics.oop;

import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{

    private SortedSet<Integer> xPositions = new TreeSet<>();
    private SortedSet<Integer> yPositions= new TreeSet<>();

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        if (oldPosition != null) {
            xPositions.remove(oldPosition.x);
            yPositions.remove(oldPosition.y);
        }
        xPositions.add(newPosition.x);
        yPositions.add(newPosition.y);
    }

    public Vector2d getMapStart(){
        return new Vector2d(xPositions.first(), yPositions.first());
    }

    public Vector2d getMapEnd(){
        return new Vector2d(xPositions.last(), yPositions.last());
    }
}
