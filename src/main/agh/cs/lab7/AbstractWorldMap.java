package main.agh.cs.lab7;


import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d,Animal> animals = new HashMap<>();
    protected Map<Vector2d,Grass> grassPos = new HashMap<>();
    protected MapBoundary boundary = new MapBoundary();


    public Map<Vector2d, Animal> getAnimals() {
        return animals;
    }

    abstract public Vector2d upperR();
    abstract public Vector2d lowerL();


    public String toString() {
        MapVisualizer mapvisualizer = new MapVisualizer(this);
        return mapvisualizer.draw(getBounds()[0],getBounds()[1]);

    }

    @Override
    public void positionChanged(Vector2d oldPosition,Vector2d newPosition) {
        Animal animal = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition,animal);
    }

    @Override
    abstract public boolean canMoveTo(Vector2d position);


    @Override
    public boolean place(Animal animal){
        if (this.isOccupied(animal.getPosition()))
            throw new IllegalArgumentException("It is not allowed to place animal, place is allready occupied");
        this.animals.put(animal.getPosition(),animal);
        animal.addObserver(this);
        boundary.addAnimal(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position){
        return animals.get(position);
    }

    public abstract Vector2d[] getBounds();
}
