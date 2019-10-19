package agh.cs.lab3;

import static java.lang.System.out;

public class World {
    public static void main(String[] args){
        Animal animal = new Animal();

        OptionsParser optionsParser = new OptionsParser();
        MoveDirection[] moveDirections = optionsParser.parse(args);

        for(MoveDirection direction : moveDirections)
            animal.move(direction);

        out.println(animal.toString());
    }
}
