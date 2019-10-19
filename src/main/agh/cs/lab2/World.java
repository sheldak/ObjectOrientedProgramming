package agh.cs.lab2;

import static java.lang.System.out;

public class World {
    public static void main(String[] args){
        Vector2d position1 = new Vector2d(1,2);
        out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        out.println(position2);
        out.println(position1.add(position2));

        Vector2d position3 = MapDirection.WEST.toUnitVector();
        out.println(position3.toString());
    }
}
