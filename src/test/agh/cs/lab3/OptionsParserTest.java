package agh.cs.lab3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {
    private OptionsParser optionsParser = new OptionsParser();

    @Test
    void parseTest(){
        String[] toParse = {"l", "f", "x", "backward", "r", "right", "left", "b", "rihgt", "forward"};
        MoveDirection[] expected = {MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.BACKWARD,
                MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.BACKWARD,
                MoveDirection.FORWARD};

        assertArrayEquals(optionsParser.parse(toParse), expected);
    }
}
