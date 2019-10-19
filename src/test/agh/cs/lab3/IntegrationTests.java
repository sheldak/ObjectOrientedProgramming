package agh.cs.lab3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTests {
    private Animal animal = new Animal();

    @Test
    void integrationTest(){
        String[] moves = {"r", "f", "k", "forward", "f", "f", "left", "b", "backward", "backward", "left", "f", "f", "f",
                "forward", "f", "f", "f", "right", "f", "f", "m", "f", "forward", "b", "f", "f", "l"};

        OptionsParser optionsParser = new OptionsParser();
        MoveDirection[] directions = optionsParser.parse(moves);

        for(MoveDirection direction : directions)
            animal.move(direction);

        assertEquals(animal.toString(), "(0, 4, Zachód)");
    }
}
