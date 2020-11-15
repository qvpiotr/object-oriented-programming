package main.agh.cs.lab5;

import main.agh.cs.lab2.MoveDirection;
import main.agh.cs.lab2.Vector2d;
import main.agh.cs.lab4.Animal;
import main.agh.cs.lab4.IEngine;
import main.agh.cs.lab4.IWorldMap;


public class SimulationEngine implements IEngine {

    public MoveDirection[] moves;
    public Vector2d[] animalsPos;
    public GrassField map;


    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] animalsPos){
        this.moves = moves;
        this.animalsPos = animalsPos;
        this.map = (GrassField) map;
        for(Vector2d pos : animalsPos) {
            ((GrassField) map).animals.add(new Animal(map, pos));
        }
    }

    public GrassField getMap() {
        return map;
    }

    @Override
    public void run() {

        for (int i = 0; i < moves.length; i++){
            int idA = i%animalsPos.length;
            map.animals.get(idA).move(moves[i]);
        }

    }
}
