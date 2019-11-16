package agh.cs.lab7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    List<Animal> animals = new ArrayList<>();
    Map<Vector2d, IMapElement> elementsMap = new HashMap<>();

    @Override
    public void run(MoveDirection[] directions) {
        int curr_animal = 0;
        for (MoveDirection direction : directions) {
            this.animals.get(curr_animal).move(direction);

            curr_animal+=1;
            curr_animal %= this.animals.size();
        }
    }

    @Override
    public boolean place(Animal animal) {
        if(!this.canMoveTo(animal.getPosition())){
            throw new IllegalArgumentException("position: " + animal.getPosition().toString() + " is occupied");
        }

        animal.addObserver(this);
        this.animals.add(animal);
        this.elementsMap.put(animal.getPosition(), animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return this.elementsMap.get(position);
    }

//    @Override
//    public void deleteObject(Vector2d position) {
//        Object object = this.objectAt(position);
//        if (object != null){
//            this.elementsMap.remove(position);
//
//            if(object instanceof Animal)
//                animals.remove(object);
//        }
//    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = (Animal) this.elementsMap.get(oldPosition);
        this.elementsMap.remove(oldPosition);

        this.elementsMap.put(newPosition, animal);
    }
}
