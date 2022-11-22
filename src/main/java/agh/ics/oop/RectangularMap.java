package agh.ics.oop;


public class RectangularMap extends AbstractWorldMap {

    private Vector2d mapEnd;
    private final Vector2d mapStart = new Vector2d(0, 0);

    public RectangularMap(int width, int height) {
        if (width > 0 && height > 0) {
            mapEnd = new Vector2d(width-1, height-1);
        }
    }

    public boolean isOccupied(Vector2d position) {
        return isAnAnimalAt(position);
    }

    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) && position.precedes(mapEnd) && position.follows(mapStart);
    }


    public Object objectAt(Vector2d position) {
        return animalAt(position);
    }

    public Vector2d findMapEnd() {
        return mapEnd;
    }

    public Vector2d findMapStart() {
        return mapStart;
    }
}
