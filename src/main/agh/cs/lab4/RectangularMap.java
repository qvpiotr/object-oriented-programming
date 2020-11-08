package main.agh.cs.lab4;

import main.agh.cs.lab2.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{
    private int width;
    private int height;
    public List<Animal> animals = new ArrayList<>();

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }


    public String toString() {
        MapVisualizer mapvisualizer = new MapVisualizer(this);

        return mapvisualizer.draw(new Vector2d(0, 0), new Vector2d(this.width - 1, this.height - 1));

    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(new Vector2d(0,0)) && position.precedes(new Vector2d(this.width-1,this.height-1))
                && !isOccupied(position);
    }

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
