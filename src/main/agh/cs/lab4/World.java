package agh.cs.lab4;

import static java.lang.System.out;

public class World {
    public static void main(String[] args){
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        map.place(new Animal(map, 3, 4));

        out.println(map.toString());
        map.run(directions);

        out.println(map.toString());
    }
}
