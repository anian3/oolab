package agh.ics.oop;



public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    MapVisualiser mapVisualiser = new MapVisualiser(this);

    public boolean place(Animal animal) throws IllegalArgumentException{
        if (canMoveTo(animal.position)) {
            animals.put(animal.position, animal);
            return true;
        }
        else {
            throw new IllegalArgumentException("The animal can't be placed at " + animal.position + ".");
        }
    }

    public boolean isAnAnimalAt(Vector2d position) {
        return animals.get(position) != null;
    }

    public Object animalAt(Vector2d position) {
        return animals.get(position);
    }

    public abstract Vector2d findMapStart();

    public abstract Vector2d findMapEnd();

    public String toString() {
        Vector2d mapStart = findMapStart();
        Vector2d mapEnd = findMapEnd();
        return mapVisualiser.draw(mapStart, mapEnd);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = animals.remove(oldPosition);
        animals.put(newPosition, animal);
    }
}
