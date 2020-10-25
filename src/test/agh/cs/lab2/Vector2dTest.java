package test.agh.cs.lab2;

import main.agh.cs.lab2.Vector2d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {

    private Vector2d v00 = new Vector2d(0,0);
    private Vector2d v11 = new Vector2d(1,1);
    private Vector2d v02 = new Vector2d(0,2);
    private Vector2d v10 = new Vector2d(1,0);
    private Vector2d v01 = new Vector2d(0,1);
    private Vector2d v22 = new Vector2d(2,2);
    private Vector2d v20 = new Vector2d(2,0);
    private Vector2d v21 = new Vector2d(2,1);
    private Vector2d v31 = new Vector2d(3,1);

    @Test
    void testEquals(){
        assertEquals(v00,v00);
        assertNotEquals(v00,v01);
        assertNotEquals(v31,v22);
        assertNotEquals(v22,v20);

        Object notvector = new Object();
        assertNotEquals(notvector, v11);
    }

    @Test
    void testToString(){
        assertEquals(v31.toString(), "(3,1)");
        assertEquals(v00.toString(), "(0,0)");
    }

    @Test
    void testPrecedes(){
        assertTrue(v11.precedes(v11));
        assertFalse(v31.precedes(v22));
    }

    @Test
    void testFollows(){
        assertFalse(v31.follows(v22));
        assertTrue(v31.follows(v00));
    }

    @Test
    void testUpperRight(){
        assertEquals(v00.upperRight(v11), v11);
        assertEquals(v31.upperRight(v10), v31);
    }

    @Test
    void testLowerLeft(){
        assertEquals(v01.lowerLeft(v10), v00);
        assertEquals(v31.lowerLeft(v22), v21);
    }

    @Test
    void testAdd(){
        assertEquals(v00.add(v11),v11);
        assertEquals(v01.add(v01),v02);
        assertEquals(v10.add(v21),v31);
    }

    @Test
    void testSubstract(){
        assertEquals(v11.substract(v00),v11);
        assertEquals(v31.substract(v21),v10);
    }

    @Test
    void testOpposite(){
        assertEquals(v00.opposite(),v00);
        Vector2d negv31 = new Vector2d(-3,-1);
        assertEquals(v31.opposite(),negv31);
    }
}
