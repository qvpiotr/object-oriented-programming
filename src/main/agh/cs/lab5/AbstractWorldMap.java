package main.agh.cs.lab5;

import main.agh.cs.lab2.Vector2d;
import main.agh.cs.lab4.Animal;
import main.agh.cs.lab4.IWorldMap;
import main.agh.cs.lab4.MapVisualizer;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    private Vector2d left;
    private Vector2d right;
    protected List<Animal> animals = new ArrayList<>();

    public List<Animal> getAnimals() {
        return animals;
    }

    abstract public Vector2d upperR();
    abstract public Vector2d lowerL();


    public String toString() {
        MapVisualizer mapvisualizer = new MapVisualizer(this);
        return mapvisualizer.draw(lowerL(),upperR());

    }

    @Override
    abstract public boolean canMoveTo(Vector2d position);


    @Override
    public boolean place(Animal animal) {
        if (this.isOccupied(animal.getPosition()))
            return false;
        animals.add(animal);
        return true;

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals){
            if(animal.getPosition().equals(position))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position){
        for(Animal animal : this.animals){
            if(animal.getPosition().equals(position))
                return animal;
        }
        return null;
    }

}
