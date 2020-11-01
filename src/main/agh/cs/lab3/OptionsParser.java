package main.agh.cs.lab3;


import main.agh.cs.lab2.MoveDirection;
import main.agh.cs.lab2.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public MoveDirection[] parse(String[] args){
        List<MoveDirection> command = new ArrayList<>();
        for (String arg : args){
            switch(arg){

                case "f", "forward" -> command.add(MoveDirection.FORWARD);
                case "b", "backward" -> command.add(MoveDirection.BACKWARD);
                case "l", "left" -> command.add(MoveDirection.LEFT);
                case "r", "right" -> command.add(MoveDirection.RIGHT);
            }
        }
        return command.toArray(MoveDirection[]::new);
    }
}
