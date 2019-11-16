package agh.cs.lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap {
    private List<Grass> grasses = new ArrayList<>();
    private final int size;

    private MapBoundary mapBoundary = new MapBoundary();

    public GrassField(int amount){
        this.size = (int) Math.sqrt(amount * 10);
        this.placeGrass(amount);
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
        this.consumeGrass(animal.getPosition());

        this.mapBoundary.addObject(animal);
        animal.addObserver(mapBoundary);
        return super.place(animal);
    }

    public void consumeGrass(Vector2d position) {
        Object object = this.objectAt(position);

        if (object instanceof Grass) {
            this.placeGrass(1);

            grasses.remove(object);
            mapBoundary.deleteObject(((Grass) object).getPosition());

            this.elementsMap.remove(((Grass) object).getPosition());
        }
    }

    private void placeGrass(int amount){
        while(amount > 0){
            int posX;
            int posY;
            boolean in;
            do{
                in = false;
                posX = new Random().nextInt(this.size);
                posY = new Random().nextInt(this.size);
                Vector2d position = new Vector2d(posX, posY);

                if(this.isOccupied(position))
                    in = true;

            } while(in);

            Grass grass = new Grass(posX, posY);
            this.elementsMap.put(new Vector2d(posX, posY), grass);
            this.grasses.add(grass);
            mapBoundary.addObject(grass);

            amount -= 1;
        }
    }

    private String draw(){
        MapVisualizer mapVisualizer = new MapVisualizer(this);

        Vector2d leftDown = new Vector2d(mapBoundary.getLeftBoundary(), mapBoundary.getLowerBoundary());
        Vector2d rightUp = new Vector2d(mapBoundary.getRightBoundary(), mapBoundary.getUpperBoundary());

        return mapVisualizer.draw(leftDown, rightUp);
    }
}
