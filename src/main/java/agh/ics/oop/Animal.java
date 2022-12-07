package agh.ics.oop;


import java.io.File;
import java.util.ArrayList;

public class Animal implements IMapElement{
    private MapDirection direction;
    private Vector2d position;
    protected IWorldMap map;
    protected ArrayList<IPositionChangeObserver> observers = new ArrayList<>();

    @Override
    public Vector2d getPosition() {
        return position;
    }

    public Animal(IWorldMap map, Vector2d InitialPosition) {
        direction = MapDirection.NORTH;
        position = InitialPosition;
        this.map = map;
        if(!map.place(this)){
            this.map = null;
        }
        addObserver((IPositionChangeObserver) map);
        if (this.map.getClass() == GrassField.class){
            addObserver(this.map.mapBoundary);
            positionChanged(null, this.position);
        }
    }

    public String toString(){
        return "Z" + position;
    }

    public boolean isAt(Vector2d position){
        return position.equals(this.position);
    }

    public void move(MoveDirection direction){
        Vector2d oldPosition = this.position;
        switch (direction) {
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD, BACKWARD -> {
                Vector2d newPosition = switch(direction){
                    case FORWARD -> this.position.add(this.direction.toUnitVector());
                    case BACKWARD -> this.position.substract(this.direction.toUnitVector());
                    default -> null;
                };
                if (map.canMoveTo(newPosition)) {
                    this.position = newPosition;
                }
            }
        }
        Vector2d newPosition = this.position;
        if (newPosition != oldPosition){
            positionChanged(oldPosition, newPosition);
        }

    }

    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer: observers){
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    public File getResources(){
        return switch(direction){
            case NORTH -> new File("src/main/resources/up.png");
            case SOUTH -> new File("src/main/resources/down.png");
            case EAST -> new File("src/main/resources/right.png");
            case WEST -> new File("src/main/resources/left.png");
        };
    }



}
