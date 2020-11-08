package main.agh.cs.lab4;


import main.agh.cs.lab2.MapDirection;
import main.agh.cs.lab2.MoveDirection;
import main.agh.cs.lab2.Vector2d;

import java.util.Objects;

public class Animal {
    private MapDirection animalDirection;
    private Vector2d position;
    private IWorldMap map;

    public Animal(IWorldMap map){
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.animalDirection = MapDirection.NORTH;
        this.position = initialPosition;
        this.map = map;
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
                break;
            case BACKWARD:
                if(this.map.canMoveTo(this.position.substract(Objects.requireNonNull(this.animalDirection.toUnitVector()))))
                    this.position = this.position.substract(Objects.requireNonNull(this.animalDirection.toUnitVector()));
                break;
        }
    }
}
