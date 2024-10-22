package test.agh.cs.lab5;

import main.agh.cs.lab2.MoveDirection;
import main.agh.cs.lab2.Vector2d;
import main.agh.cs.lab3.OptionsParser;

import main.agh.cs.lab4.Animal;
import main.agh.cs.lab4.IEngine;
import main.agh.cs.lab5.SimulationEngine;
import main.agh.cs.lab5.GrassField;
import main.agh.cs.lab5.RectangularMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {

    @Test
    void Test1(){
        String[] command = {"f","k","right","f","f","f","l","left","right","f","forward","l", "r","backward","b","right"};
        MoveDirection[] directions = new OptionsParser().parse(command);
        GrassField map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        StringBuilder expected = new StringBuilder();
        for (Animal animal : map.getAnimals()){
            expected.append(animal.getPosition().toString()).append(animal.toString());
        }

        assertEquals(expected.toString(),"(1,6)W(5,5)S");

    }

    @Test
    void Test2(){
        String[] command = {"b","r","l","l","f","r","b","t","r","b","b", "r","backward","f","right"};
        MoveDirection[] directions = new OptionsParser().parse(command);
        GrassField map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        StringBuilder expected = new StringBuilder();
        for (Animal animal : map.getAnimals()){
            expected.append(animal.getPosition().toString()).append(animal.toString());
        }

        assertEquals(expected.toString(),"(3,2)N(3,6)W");

    }

    @Test
    void Test3(){
        String[] command = {"b","r","l","l","f","r","b","t","r","b","b", "r","backward","f","right"};
        MoveDirection[] directions = new OptionsParser().parse(command);
        RectangularMap map = new RectangularMap(10,10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        StringBuilder expected = new StringBuilder();
        for (Animal animal : map.getAnimals()){
            expected.append(animal.getPosition().toString()).append(animal.toString());
        }

        assertEquals(expected.toString(),"(3,2)N(3,6)W");

    }
}
