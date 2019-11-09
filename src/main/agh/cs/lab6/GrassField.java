package agh.cs.lab6;

import java.util.ArrayList;
import java.util.List;

public class GrassField extends AbstractWorldMap {
    List<Grass> grasses = new ArrayList<>();
    final int size;

    public GrassField(int amount){
        this.size = (int) Math.sqrt(amount * 10);
        Grass.placeGrass(this, amount);
    }

    @Override
    public String toString() {
        if (this.elementsMap.isEmpty())
            return "";

        return this.draw();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(isOccupied(position) && objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal){
        if(objectAt(animal.getPosition()) instanceof Grass){
            Grass.placeGrass(this, 1);
            this.destroyObject(animal.getPosition());
        }
        return super.place(animal);
    }

    @Override
    public void destroyObject(Vector2d position) {
        Object object = this.objectAt(position);
        if (object instanceof Grass)
                grasses.remove(object);

        super.destroyObject(position);
    }

    private String draw(){
        MapVisualizer mapVisualizer = new MapVisualizer(this);

        Vector2d leftDown = new Vector2d(0, 0);
        Vector2d rightUp = new Vector2d(0, 0);

        for(Animal animal: this.animals){
            leftDown = leftDown.lowerLeft(animal.getPosition());
            rightUp = rightUp.upperRight(animal.getPosition());
        }

        for(Grass grass : this.grasses){
            leftDown = leftDown.lowerLeft(grass.getPosition());
            rightUp = rightUp.upperRight(grass.getPosition());
        }

        return mapVisualizer.draw(leftDown, rightUp);
    }
}
