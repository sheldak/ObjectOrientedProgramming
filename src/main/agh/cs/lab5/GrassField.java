package agh.cs.lab5;

import java.lang.Math;

public class GrassField extends AbstractWorldMap {
    public final int size;

    public GrassField(int amount){
        size = (int) Math.sqrt(amount * 10);
        Grass.place_grass(this, amount);
    }

    @Override
    public String toString() {
        if (this.elements.isEmpty())
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
            Grass.place_grass(this, 1);
            this.destroyObject(animal.getPosition());
        }
        return super.place(animal);
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(IMapElement element : this.elements){
            if(element.getPosition().equals(position) && element instanceof Animal)
                return element;
        }
        return super.objectAt(position);
    }

    private String draw(){
        MapVisualizer mapVisualizer = new MapVisualizer(this);

        Vector2d left_down = this.elements.get(0).getPosition();
        Vector2d right_up = this.elements.get(0).getPosition();

        for(IMapElement element : this.elements){
            left_down = left_down.lowerLeft(element.getPosition());
            right_up = right_up.upperRight(element.getPosition());
        }

        return mapVisualizer.draw(left_down, right_up);
    }
}
