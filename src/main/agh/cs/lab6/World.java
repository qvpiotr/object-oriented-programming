package main.agh.cs.lab6;


import main.agh.cs.lab2.MoveDirection;
import main.agh.cs.lab4.IEngine;



public class World {

    public static void main(String[] args){
//        MoveDirection[] directions = new OptionsParser().parse(args);
        MoveDirection[] directions = {MoveDirection.FORWARD, MoveDirection.LEFT,MoveDirection.RIGHT,MoveDirection.FORWARD};
        AbstractWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        System.out.println(map.toString());

        engine.run();

        System.out.println(map.toString());
    }
}
