package agh.cs.lab6;

import java.util.Arrays;

public class OptionsParser {
    public OptionsParser(){

    }

    public MoveDirection[] parse(String[] moves){
        MoveDirection[] moveDirections = new MoveDirection[moves.length];
        int currIndex = 0;

        for(String move : moves){
            switch (move) {
                case "f":
                case "forward":
                    moveDirections[currIndex] = MoveDirection.FORWARD;
                    currIndex += 1;
                    break;
                case "r":
                case "right":
                    moveDirections[currIndex] = MoveDirection.RIGHT;
                    currIndex += 1;
                    break;
                case "b":
                case "backward":
                    moveDirections[currIndex] = MoveDirection.BACKWARD;
                    currIndex += 1;
                    break;
                case "l":
                case "left":
                    moveDirections[currIndex] = MoveDirection.LEFT;
                    currIndex += 1;
                    break;
                default:
                    throw new IllegalArgumentException(move + " is not legal move specification");
            }
        }
        return Arrays.copyOfRange(moveDirections, 0, currIndex);
    }
}
