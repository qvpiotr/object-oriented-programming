package test.agh.cs.lab3;

import main.agh.cs.lab2.MoveDirection;
import main.agh.cs.lab3.OptionsParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OptionsParserTest {

    private OptionsParser optionsparser= new OptionsParser();

    @Test
    void TestParse(){
        String[] command = {"left","forward", "f", "s", "r","backward","b","xs","f","r"};
        MoveDirection[] correct = {MoveDirection.LEFT ,MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT,
        MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.FORWARD, MoveDirection.RIGHT};

        assertArrayEquals(optionsparser.parse(command),correct);

    }
}
