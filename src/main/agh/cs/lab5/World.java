package agh.cs.lab5;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class World {
    public static void main(String[] args){
        MoveDirection[] directions = new OptionsParser().parse(args);
        //String[] moves = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        //MoveDirection[] directions = new OptionsParser().parse(moves);

        List<HayStack> hayStacks = new ArrayList<>();
        hayStacks.add(new HayStack(-4, -4));
        hayStacks.add(new HayStack(7, 7));
        hayStacks.add(new HayStack(3, 6));
        hayStacks.add(new HayStack(2, 0));

        IWorldMap map = new UnboundedMap(hayStacks);
        map.place(new Animal(map));
        map.place(new Animal(map, 3, 4));

        out.println(map.toString());
        map.run(directions);

        out.println(map.toString());

    }
}
