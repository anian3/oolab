package agh.ics.oop;


import java.util.ArrayList;

public class Animal {
    private MapDirection direction;
    protected Vector2d position;
    protected IWorldMap map;
    protected ArrayList<IPositionChangeObserver> observers = new ArrayList<>();

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
        return switch (this.direction){
            case NORTH -> "N";
            case EAST -> "E";
            case SOUTH -> "S";
            case WEST -> "W";
        };
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



}
