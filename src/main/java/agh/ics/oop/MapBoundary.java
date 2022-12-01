package agh.ics.oop;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{

    private SortedSet<Vector2d> xPositions = new TreeSet<>(Comparator.comparingInt(position -> position.x));
    private SortedSet<Vector2d> yPositions = new TreeSet<>(Comparator.comparingInt(position -> position.y));

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        if (oldPosition != null) {
            xPositions.remove(oldPosition);
            yPositions.remove(oldPosition);
        }
        xPositions.add(newPosition);
        yPositions.add(newPosition);
    }

    public Vector2d getMapStart(){
        return new Vector2d(xPositions.first().x, yPositions.first().y);
    }

    public Vector2d getMapEnd(){
        return new Vector2d(xPositions.last().x, yPositions.last().y);
    }
}
