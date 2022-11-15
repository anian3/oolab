package agh.ics.oop;
import java.util.ArrayList;


public abstract class AbstractWorldMap implements IWorldMap{

    protected ArrayList<Animal> animals = new ArrayList<>();

    public boolean place(Animal animal) {
        if (canMoveTo(animal.position)) {
            animals.add(animal);
            return true;
        }
        return false;
    }

    public boolean isAnAnimalAt(Vector2d position){
        for (Animal animal : animals) {
            if (animal.isAt(position)) {
                return true;
            }
        }
        return false;
    }

    public Object animalAt(Vector2d position){
        for (Animal animal : animals) {
            if (animal.isAt(position)) {
                return animal;
            }
        }
        return null;
    }

    public abstract Vector2d findMapStart();
    public abstract Vector2d findMapEnd();

    public String toString(){
        Vector2d mapStart = findMapStart();
        Vector2d mapEnd = findMapEnd();
        MapVisualiser map = new MapVisualiser(this);
        return map.draw(mapStart, mapEnd);
    }
}
