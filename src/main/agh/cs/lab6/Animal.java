package main.agh.cs.lab6;


import main.agh.cs.lab2.MoveDirection;


import java.util.ArrayList;
import java.util.Objects;

public class Animal {
    private MapDirection animalDirection;
    private Vector2d position;
    private IWorldMap map;
    private ArrayList<IPositionChangeObserver> observers = new ArrayList<IPositionChangeObserver>();

    public Animal(IWorldMap map){
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.animalDirection = MapDirection.NORTH;
        this.position = initialPosition;
        this.map = map;
    }

    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    public void positionChanged(Vector2d oldPos, Vector2d newPos){
        for(IPositionChangeObserver observer : observers){
            observer.positionChanged(oldPos, newPos);
        }
    }

    public String toString(){
        switch(animalDirection){
            case NORTH: return "N";
            case SOUTH: return "S";
            case EAST: return "E";
            case WEST: return "W";
            default: return "error";
        }
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public void move(MoveDirection direction){
        Vector2d prev = this.position;
        switch(direction){
            case RIGHT:
                this.animalDirection = this.animalDirection.next();
                break;
            case LEFT:
                this.animalDirection = this.animalDirection.previous();
                break;
            case FORWARD:
                if(this.map.canMoveTo(this.position.add(Objects.requireNonNull(this.animalDirection.toUnitVector()))))
                    this.position = this.position.add(Objects.requireNonNull(this.animalDirection.toUnitVector()));
                    positionChanged(prev,position);
                break;
            case BACKWARD:
                if(this.map.canMoveTo(this.position.substract(Objects.requireNonNull(this.animalDirection.toUnitVector()))))
                    this.position = this.position.substract(Objects.requireNonNull(this.animalDirection.toUnitVector()));
                    positionChanged(prev,position);
                break;
        }
    }
}
