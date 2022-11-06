package agh.ics.oop;


public class Animal {
    private MapDirection direction;
    protected Vector2d position;
    private IWorldMap map;

    public Animal(IWorldMap map, Vector2d InitialPosition) {
        direction = MapDirection.NORTH;
        position = InitialPosition;
        this.map = map;
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

    }


}
