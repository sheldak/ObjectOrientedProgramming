package agh.cs.lab5;

import static java.lang.System.out;

public class World {
    public static void main(String[] args){
        MoveDirection[] directions = new OptionsParser().parse(args);
        //String[] moves = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        //MoveDirection[] directions = new OptionsParser().parse(moves);

        IWorldMap map = new GrassField(10);
        map.place(new Animal(map));
        map.place(new Animal(map, 3, 4));

        out.println(map.toString());
        map.run(directions);

        out.println(map.toString());

    }
}
