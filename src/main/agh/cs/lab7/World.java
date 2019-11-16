package agh.cs.lab7;

import static java.lang.System.exit;
import static java.lang.System.out;

public class World {
    public static void main(String[] args){
        try{
            //String[] moves = {"f", "f", "f", "f", "f", "f", "f", "f", "f"};
            MoveDirection[] directions = new OptionsParser().parse(args);

            AbstractWorldMap map = new GrassField(5);

            map.place(new Animal(map, 2, 2));
            map.place(new Animal(map, 4, 2));

            out.println(map.toString());
            map.run(directions);

            out.println(map.toString());
        } catch (IllegalArgumentException ex){
            out.println(ex);
            exit(0);
        }
    }
}
