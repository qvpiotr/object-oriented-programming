package main.agh.cs.lab7;

import java.util.Comparator;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{

    private TreeSet<Vector2d> xSet = new TreeSet<>(Comparator.comparing(v -> v.x));
    private TreeSet<Vector2d> ySet = new TreeSet<>(Comparator.comparing(v -> v.y));

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        xSet.remove(oldPosition);
        xSet.add(newPosition);
        ySet.remove(oldPosition);
        ySet.add(newPosition);
    }

    public void addPosition(Vector2d position){
        xSet.add(position);
        ySet.add(position);
    }

    public void removePosition(Vector2d position){
        xSet.remove(position);
        ySet.remove(position);
    }

    public Vector2d lowerLeft(){
        return xSet.first().lowerLeft(ySet.first());
    }

    public Vector2d upperRight(){
        return xSet.last().upperRight(ySet.last());
    }

    public void addAnimal(Animal animal){
        animal.addObserver(this);
    }

}
