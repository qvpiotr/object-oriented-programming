package main.agh.cs.lab4;

import main.agh.cs.lab2.MoveDirection;
import main.agh.cs.lab2.Vector2d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class SimulationEngine implements IEngine{

    public MoveDirection[] moves;
    public Vector2d[] animalsPos;
    public RectangularMap map;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] animalsPos){
        this.moves = moves;
        this.animalsPos = animalsPos;
        this.map = (RectangularMap) map;
        for(Vector2d pos : animalsPos) {
            ((RectangularMap) map).animals.add(new Animal(map, pos));
        }
    }

    public RectangularMap getMap() {
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
