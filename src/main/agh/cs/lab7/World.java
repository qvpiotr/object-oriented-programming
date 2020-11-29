package main.agh.cs.lab7;


import main.agh.cs.lab2.MoveDirection;
import main.agh.cs.lab3.OptionsParser;
import main.agh.cs.lab4.IEngine;


public class World {

    public static void main(String[] args){
        try {
//            MoveDirection[] directions = new OptionsParser().parse(args);
            MoveDirection[] directions = {MoveDirection.FORWARD, MoveDirection.LEFT,MoveDirection.RIGHT,MoveDirection.FORWARD};
            String[] command = {"f","k","right","f","f","f","l","left","right","f","forward","l", "r","backward","b","right"};
            MoveDirection[] directions1 = new OptionsParser().parse(command);
            AbstractWorldMap map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions1, map, positions);
            System.out.println(map.toString());

            engine.run();

            System.out.println(map.toString());
        }catch (IllegalArgumentException ex){
            System.out.println(ex.toString());
            System.exit(1);
        }
    }
}
