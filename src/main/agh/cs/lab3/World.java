package main.agh.cs.lab3;


import main.agh.cs.lab2.MoveDirection;

public class World {

    public static void main(String[] args){
        Animal bear = new Animal();
        OptionsParser optionsparser = new OptionsParser();
        MoveDirection[] moveDirections = optionsparser.parse(args);

        for(MoveDirection direction : moveDirections)
            bear.move(direction);


        System.out.println(bear.toString());

    }
}
