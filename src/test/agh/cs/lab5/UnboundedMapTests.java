package agh.cs.lab5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UnboundedMapTests {
    public List<HayStack> hayStacks = new ArrayList<>();

    @Test
    void canMoveToTest() {
        hayStacks.add(new HayStack(-4, -4));
        UnboundedMap map = new UnboundedMap(hayStacks);
        map.place(new Animal(map, 1, 1));

        assertTrue(map.canMoveTo(new Vector2d(0, 0)));

        assertFalse(map.canMoveTo(new Vector2d(-4, -4)));
        assertFalse(map.canMoveTo(new Vector2d(1, 1)));
    }

    @Test
    void placeTest() {
        hayStacks.add(new HayStack(-4, -4));
        UnboundedMap map = new UnboundedMap(hayStacks);

        assertTrue(map.place(new Animal(map, -5, -5)));

        assertFalse(map.place(new Animal(map, -5, -5)));
        assertFalse(map.place(new Animal(map, -4, -4)));
    }

    @Test
    void runTest() {
        hayStacks.add(new HayStack(1, 2));
        UnboundedMap map = new UnboundedMap(hayStacks);
        map.place(new Animal(map, 1, 0));
        map.place(new Animal(map, 1, 3));

        MoveDirection[] directions = new MoveDirection[8];
        directions[0] = MoveDirection.FORWARD;
        directions[1] = MoveDirection.BACKWARD;
        directions[2] = MoveDirection.FORWARD;
        directions[3] = MoveDirection.BACKWARD;
        directions[4] = MoveDirection.FORWARD;
        directions[5] = MoveDirection.RIGHT;
        directions[6] = MoveDirection.LEFT;
        directions[7] = MoveDirection.RIGHT;

        map.run(directions);

        assertEquals(map.elements.get(0).getPosition(), new Vector2d(1, 2));
        assertEquals(map.elements.get(1).getPosition(), new Vector2d(1, 1));
        assertEquals(map.elements.get(2).getPosition(), new Vector2d(1, 3));
        assertEquals(map.elements.get(1).toString(), "W");
        assertEquals(map.elements.get(2).toString(), "S");
    }

    @Test
    void isOccupiedTest() {
        hayStacks.add(new HayStack(2, 2));
        UnboundedMap map = new UnboundedMap(hayStacks);

        for(int i=0; i<3; i+=1){
            for(int j=0; j<3; j+=1){
                if(i==2 && j==2)
                    assertTrue(map.isOccupied(new Vector2d(i, j)));
                else
                    assertFalse(map.isOccupied(new Vector2d(i, j)));
            }
        }

        map.place(new Animal(map, 0, 0));

        for(int i=0; i<3; i+=1){
            for(int j=0; j<3; j+=1){
                if((i==2 && j==2)||(i==0 && j==0))
                    assertTrue(map.isOccupied(new Vector2d(i, j)));
                else
                    assertFalse(map.isOccupied(new Vector2d(i, j)));
            }
        }
    }

    @Test
    void objectAtTest() {
        HayStack hayStack_2_2 = new HayStack(2, 2);
        hayStacks.add(hayStack_2_2);
        UnboundedMap map = new UnboundedMap(hayStacks);

        Animal animal_0_0 = new Animal(map, 0, 0);
        map.place(animal_0_0);

        for(int i=0; i<3; i+=1){
            for(int j=0; j<3; j+=1){
                if(i==0 && j==0)
                    assertEquals(map.objectAt(new Vector2d(i, j)), animal_0_0);
                else if(i==2 && j==2)
                    assertEquals(map.objectAt(new Vector2d(i, j)), hayStack_2_2);
                else
                    assertNull(map.objectAt(new Vector2d(i, j)));
            }
        }
    }
}
