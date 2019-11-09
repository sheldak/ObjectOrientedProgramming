package agh.cs.lab6;

import static java.lang.System.out;
import static java.lang.System.exit;

public class World {
    public static void main(String[] args){
        try{
            String[] moves = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};

            MoveDirection[] directions = new OptionsParser().parse(moves);

            //String[] moves = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
            //MoveDirection[] directions = new OptionsParser().parse(moves);

            IWorldMap map = new GrassField(1);

            map.place(new Animal(map));
            map.place(new Animal(map, 2, 2));

            out.println(map.toString());
            map.run(directions);

            out.println(map.toString());
        } catch (IllegalArgumentException ex){
            out.println(ex);
            exit(0);
        }
    }
}
