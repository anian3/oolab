package agh.ics.oop;


public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);

    public String toString(){
        return position.toString() + " " + direction.toString();
    }

    public boolean isAt(Vector2d position){
        return position.equals(this.position);
    }

    public void move(MoveDirection direction){
        switch (direction) {
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> {
                Vector2d forwardPosition = this.position.add(this.direction.toUnitVector());
                if (forwardPosition.precedes(new Vector2d(4, 4))) {
                    this.position = forwardPosition;
                }
            }
            case BACKWARD -> {
                Vector2d backwardPosition = this.position.substract(this.direction.toUnitVector());
                if (backwardPosition.precedes(new Vector2d(4, 4))) {
                    this.position = backwardPosition;
                }
            }
        }

    }


}
