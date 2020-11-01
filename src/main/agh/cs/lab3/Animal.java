package main.agh.cs.lab3;


import main.agh.cs.lab2.MapDirection;
import main.agh.cs.lab2.MoveDirection;
import main.agh.cs.lab2.Vector2d;

public class Animal {
    private MapDirection animalDirection;
    private Vector2d position;

    public Animal(){
        this.animalDirection = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }

    public String toString(){
        return "(" + this.position.x + "," + this.position.y + ")" + "," + this.animalDirection.toString();
    }

    public void move(MoveDirection direction){

        Vector2d v00 = new Vector2d(0,0);
        Vector2d v44 = new Vector2d(4,4);
        switch(direction){
            case RIGHT:
                this.animalDirection = this.animalDirection.next();
                break;
            case LEFT:
                this.animalDirection = this.animalDirection.previous();
                break;
            case FORWARD:
                Vector2d forward = this.position.add(this.animalDirection.toUnitVector());
                if (v00.precedes(forward) && v44.follows(forward))
                    this.position = forward;
                break;
            case BACKWARD:
                Vector2d backward = this.position.substract(this.animalDirection.toUnitVector());
                if (v00.precedes(backward) && v44.follows(backward))
                    this.position = backward;
                break;
        }
    }
}
