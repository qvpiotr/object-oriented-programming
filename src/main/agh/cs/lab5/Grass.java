package main.agh.cs.lab5;

import main.agh.cs.lab2.Vector2d;

import java.util.Random;

public class Grass {
    private Vector2d position;

    public Grass(Vector2d pos){
        this.position = pos;
    }

    public Vector2d getPosition() {
        return position;
    }

    public String toString(){
        return "*";
    }
}
