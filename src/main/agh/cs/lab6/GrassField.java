package agh.cs.lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap {
    public GrassField(int amount){
        int maxx = (int) Math.sqrt(amount * 10);
        List<Grass> grasses = new ArrayList<>();

        while(amount > 0){
            int pos_x;
            int pos_y;

            boolean in;
            do{
                in = false;
                pos_x = new Random().nextInt(maxx);
                pos_y = new Random().nextInt(maxx);
                Vector2d position = new Vector2d(pos_x, pos_y);

                for (Grass grass : grasses){
                    if (grass.getPosition().equals(position)) {
                        in = true;
                        break;
                    }
                }
            }while(in);

            grasses.add(new Grass(pos_x, pos_y));

            amount -= 1;
        }

        this.elements.addAll(grasses);

        for(Grass grass : grasses){
            this.elementsMap.put(grass.getPosition(), grass);
        }
    }

    @Override
    public String toString() {
        if (this.elements.isEmpty())
            return "";

        MapVisualizer mapVisualizer = new MapVisualizer(this);

        Vector2d left_down = this.elements.get(0).getPosition();
        Vector2d right_up = this.elements.get(0).getPosition();

        for(IMapElement element : this.elements){
            left_down = left_down.lowerLeft(element.getPosition());
            right_up = right_up.upperRight(element.getPosition());
        }

        return mapVisualizer.draw(left_down, right_up);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return elementsMap.containsKey(position) && elementsMap.get(position) instanceof Animal;
    }

    @Override
    public Object objectAt(Vector2d position) { // TODO better two maps: animals and grass
        if (elementsMap.containsKey(position)){
            IMapElement element = elementsMap.get(position);
            if (element instanceof Animal)
                return element;
        }
        for(IMapElement element : this.elements){
            if(element.getPosition().equals(position) && element instanceof Animal)
                return element;
        }
        for(IMapElement element : this.elements){
            if(element.getPosition().equals(position))
                return element;
        }
        return null;
    }
}
