package agh.cs.lab4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
    private int width = 3;
    private int height = 2;
    private RectangularMap map = new RectangularMap(width, height);

    private Animal animal_1_1 = new Animal(map, 1,1);
    private Animal animal_1_1a = new Animal(map, 1,1);
    private Animal animal_1_0 = new Animal(map, 1,0);

    @Test
    void canMoveToTest() {
        assertTrue(map.canMoveTo(new Vector2d(0, 0)));
        assertTrue(map.canMoveTo(new Vector2d(1, 1)));
        assertTrue(map.canMoveTo(new Vector2d(2, 1)));

        assertFalse(map.canMoveTo(new Vector2d(3, 2)));
        assertFalse(map.canMoveTo(new Vector2d(5, 4)));
        assertFalse(map.canMoveTo(new Vector2d(1, 2)));
        assertFalse(map.canMoveTo(new Vector2d(3, 0)));
    }

    @Test
    void placeTest() {
        assertTrue(map.place(animal_1_1));
        assertFalse(map.place(animal_1_1a));
    }

    @Test
    void runTest() {
        MoveDirection[] directions = new MoveDirection[3];
        directions[0] = MoveDirection.FORWARD;
        directions[1] = MoveDirection.BACKWARD;
        directions[2] = MoveDirection.LEFT;

        map.place(animal_1_1);
        map.place(animal_1_0);
        map.run(directions);

        assertEquals(map.animals.get(0).getPosition(), new Vector2d(1, 1));
        assertEquals(map.animals.get(1).getPosition(), new Vector2d(1, 0));
        assertEquals(map.animals.get(0).toString(), "W");
        assertEquals(map.animals.get(1).toString(), "N");
    }

    @Test
   void isOccupiedTest() {
        for(int i=0; i<width; i+=1){
            for(int j=0; j<height; j+=1){
                assertFalse(map.isOccupied(new Vector2d(i, j)));
            }
        }

        map.place(animal_1_1);

        for(int i=0; i<width; i+=1){
            for(int j=0; j<height; j+=1){
                if(i==1 && j==1)
                    assertTrue(map.isOccupied(new Vector2d(1, 1)));
                else
                    assertFalse(map.isOccupied(new Vector2d(i, j)));
            }
        }
    }

    @Test
    void objectAtTest() {
        for(int i=0; i<width; i+=1){
            for(int j=0; j<height; j+=1){
                assertNull(map.objectAt(new Vector2d(i, j)));
            }
        }

        map.place(animal_1_1);

        for(int i=0; i<width; i+=1){
            for(int j=0; j<height; j+=1){
                if(i==1 && j==1)
                    assertEquals(map.objectAt(new Vector2d(1, 1)), animal_1_1);
                else
                    assertNull(map.objectAt(new Vector2d(i, j)));
            }
        }
    }
}
