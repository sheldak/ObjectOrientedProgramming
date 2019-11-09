package agh.cs.lab6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap {
    public List<IMapElement> elements = new ArrayList<>();
    public Map<Vector2d, IMapElement> elementsMap = new HashMap<>();

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
        if(this.isOccupied(animal.getPosition())){
            throw new IllegalArgumentException("position: " + animal.getPosition().toString() + " is occupied");
        }

        this.elements.add(animal);
        this.elementsMap.put(animal.getPosition(), animal);
        return true;
    }
}
