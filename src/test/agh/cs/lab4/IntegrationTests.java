package agh.cs.lab4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTests {

    @Test
    void integrationTest(){
        String[] moves = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};

        OptionsParser optionsParser = new OptionsParser();
        MoveDirection[] directions = optionsParser.parse(moves);

        IWorldMap map = new RectangularMap(10, 5);

        Animal animal1 = new Animal(map);
        map.place(animal1);
        assertTrue(map.isOccupied(new Vector2d(2, 2)));

        Animal animal2 = new Animal(map, 3, 4);
        map.place(animal2);
        assertTrue(map.isOccupied(new Vector2d(3, 4)));

        map.run(directions);

        assertEquals(map.objectAt(new Vector2d(2, 0)), animal1);
        assertEquals(map.objectAt(new Vector2d(2, 0)).toString(), "S");

        assertEquals(map.objectAt(new Vector2d(3, 4)), animal2);
        assertEquals(map.objectAt(new Vector2d(3, 4)).toString(), "N");

    }
}
