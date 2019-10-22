package agh.cs.lab4;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private int width;
    private int height;
    public List<Animal> animals = new ArrayList<>();

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);

        return mapVisualizer.draw(new Vector2d(0,0), new Vector2d(this.width-1, this.height-1));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        Vector2d v_0_0 = new Vector2d(0, 0);
        Vector2d v_w_h = new Vector2d(this.width-1, this.height-1);

        return position.follows(v_0_0) && position.precedes(v_w_h) && !this.isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if(this.isOccupied(animal.getPosition()))
            return false;

        animals.add(animal);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int curr_animal = 0;
        for (MoveDirection direction : directions){
            animals.get(curr_animal).move(direction);

            curr_animal+=1;
            curr_animal %= animals.size();
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal animal : animals){
            if(animal.getPosition().equals(position))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal : animals){
            if(animal.getPosition().equals(position))
                    return animal;
        }
        return null;
    }
}
