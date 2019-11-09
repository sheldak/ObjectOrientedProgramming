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
        if (this.canMoveTo(animal.getPosition())) {
            this.elements.add(animal);
            return true;
        }

        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(IMapElement element : this.elements){
            if(element.getPosition().equals(position))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(IMapElement element : this.elements){
            if(element.getPosition().equals(position))
                return element;
        }
        return null;
    }

    @Override
    public void destroyObject(Vector2d position) {
        if (this.objectAt(position) != null)
            this.elements.remove(this.objectAt(position));
    }
}
