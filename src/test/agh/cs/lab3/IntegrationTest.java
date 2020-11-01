package test.agh.cs.lab3;

import main.agh.cs.lab2.MoveDirection;
import main.agh.cs.lab3.Animal;
import main.agh.cs.lab3.OptionsParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {
    private Animal animal = new Animal();

    @Test
    void IntegrationTest(){
        String[] command = {"f","k","right","f","f","f","l","left","right","f","forward","l", "r","backward","b","right"};

        OptionsParser optionsparser = new OptionsParser();
        MoveDirection[] moves = optionsparser.parse(command);

        for(MoveDirection move : moves)
            animal.move(move);

        assertEquals(animal.toString(), "(4,2),Wschód");
    }
}
