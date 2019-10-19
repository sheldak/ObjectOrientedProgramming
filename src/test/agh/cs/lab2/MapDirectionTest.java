package agh.cs.lab2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MapDirectionTest {
    @Test
    void testNext(){
        assertEquals(MapDirection.NORTH.next(), MapDirection.EAST);
        assertEquals(MapDirection.EAST.next(), MapDirection.SOUTH);
        assertEquals(MapDirection.SOUTH.next(), MapDirection.WEST);
        assertEquals(MapDirection.WEST.next(), MapDirection.NORTH);
    }

    @Test
    void testPrevious(){
        assertEquals(MapDirection.NORTH.previous(), MapDirection.WEST);
        assertEquals(MapDirection.EAST.previous(), MapDirection.NORTH);
        assertEquals(MapDirection.SOUTH.previous(), MapDirection.EAST);
        assertEquals(MapDirection.WEST.previous(), MapDirection.SOUTH);
    }

    @Test
    void testToUnitVector(){
        Vector2d v_0_1 = new Vector2d(0, 1);
        Vector2d v_1_0 = new Vector2d(1, 0);
        Vector2d v_0_neg1 = new Vector2d(0, -1);
        Vector2d v_neg1_0 = new Vector2d(-1, 0);
        assertEquals(MapDirection.NORTH.toUnitVector(), v_0_1);
        assertEquals(MapDirection.EAST.toUnitVector(), v_1_0);
        assertEquals(MapDirection.SOUTH.toUnitVector(), v_0_neg1);
        assertEquals(MapDirection.WEST.toUnitVector(), v_neg1_0);
    }

}
