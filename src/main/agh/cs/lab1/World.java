package agh.cs.lab1;

import java.util.Arrays;

import static java.lang.System.out;

public class World {
    private static Direction[] stringToDirection(String[] args){
        Direction[] argsDirection = new Direction[args.length];

        int currPos = 0;
        for(String arg : args){
            switch(arg){
                case "f":
                    argsDirection[currPos] = Direction.FORWARD;
                    currPos += 1;
                    break;
                case "b":
                    argsDirection[currPos] = Direction.BACKWARD;
                    currPos += 1;
                    break;
                case "r":
                    argsDirection[currPos] = Direction.RIGHT;
                    currPos += 1;
                    break;
                case "l":
                    argsDirection[currPos] = Direction.LEFT;
                    currPos += 1;
                    break;
            }
        }
        return Arrays.copyOfRange(argsDirection, 0, currPos);
    }

    private static void run(Direction[] args){
        for(Direction arg : args){
            switch(arg){
                case FORWARD:
                    out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    out.println("Zwierzak idzie do tyłu");
                    break;
                case RIGHT:
                    out.println("Zwierzak skręca w prawo");
                    break;
                case LEFT:
                    out.println("Zwierzak skręca w lewo");
                    break;
            }
        }
    }

    public static void main(String[] args){
        out.println("Start");

        Direction[] argsDirection = stringToDirection(args);

        run(argsDirection);

        out.println("Stop");
    }
}
