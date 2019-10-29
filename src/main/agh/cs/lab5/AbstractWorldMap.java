package agh.cs.lab5;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap{
    public List<IMapElement> elements = new ArrayList<>();

    @Override
    public void run(MoveDirection[] directions) {
        List<Animal> animals = new ArrayList<>();
        for (IMapElement element: this.elements){
            if (element instanceof Animal){
                animals.add((Animal) element);
            }
        }

        int curr_animal = 0;
        for (MoveDirection direction : directions){
            animals.get(curr_animal).move(direction);

            curr_animal+=1;
            curr_animal %= animals.size();
        }
    }

    @Override
    public boolean place(Animal animal) {
        if(this.isOccupied(animal.getPosition()))
            return false;

        this.elements.add(animal);
        return true;
    }
}
