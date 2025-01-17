package main.agh.cs.lab7;

import main.agh.cs.lab2.MoveDirection;
import main.agh.cs.lab4.IEngine;

import java.util.ArrayList;
import java.util.List;


public class SimulationEngine implements IEngine {

    public MoveDirection[] moves;
    public Vector2d[] animalsPos;
    public AbstractWorldMap map;


    public SimulationEngine(MoveDirection[] moves, AbstractWorldMap map, Vector2d[] animalsPos){
        this.moves = moves;
        this.animalsPos = animalsPos;
        this.map = map;
        for(Vector2d pos : animalsPos) {
//            map.animals.put(pos,new Animal(map, pos));
            Animal animal = new Animal(this.map,pos);
            this.map.place(animal);
            map.animals.put(pos,animal);
        }
    }

    public AbstractWorldMap getMap() {
        return map;
    }

    @Override
    public void run() {
        List <Animal> animArray = new ArrayList<>(map.animals.values());

        for (int i = 0; i < moves.length; i++){
            int idA = i%animalsPos.length;
            animArray.get(idA).move(moves[i]);
        }
    }
}