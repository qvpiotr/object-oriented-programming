package test.agh.cs.lab3;

import main.agh.cs.lab2.MoveDirection;
import main.agh.cs.lab3.Animal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {
    private Animal animal = new Animal();

    @Test
    void TestToString(){
        assertEquals(animal.toString(), "(2,2),Północ");
    }

    @Test
    void TestMove(){
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        assertEquals(animal.toString(), "(2,2),Zachód");

        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.toString(), "(0,2),Zachód");

        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.LEFT);
        assertEquals(animal.toString(), "(1,2),Południe");

        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.LEFT);
        assertEquals(animal.toString(), "(1,0),Wschód");
    }

}

