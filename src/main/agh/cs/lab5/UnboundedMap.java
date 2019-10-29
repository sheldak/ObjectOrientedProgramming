package agh.cs.lab5;

import java.util.ArrayList;
import java.util.List;

public class UnboundedMap extends AbstractWorldMap {
    public UnboundedMap(List<HayStack> hayStacks){
        this.elements.addAll(hayStacks);
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
}
