package agh.cs.lab7;

import java.util.Comparator;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {
    private Comparator<Vector2d> xComparator = Comparator.comparing(Vector2d::getX).thenComparing(Vector2d::getY);
    private Comparator<Vector2d> yComparator = Comparator.comparing(Vector2d::getY).thenComparing(Vector2d::getX);

    private TreeSet<Vector2d> xElements = new TreeSet<>(xComparator);
    private TreeSet<Vector2d> yElements = new TreeSet<>(yComparator);

    private int leftBoundary;
    private int rightBoundary;
    private int upperBoundary;
    private int lowerBoundary;

    public MapBoundary(){

    }

    public void addObject(IMapElement element){
        this.xElements.add(element.getPosition());
        this.yElements.add(element.getPosition());

        this.updateBoundaries(element.getPosition());

    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        this.xElements.remove(oldPosition);
        this.xElements.add(newPosition);

        this.yElements.remove(oldPosition);
        this.yElements.add(newPosition);

        this.updateBoundaries(newPosition);
    }

    public void deleteObject(Vector2d position){
        this.xElements.remove(position);
        this.yElements.remove(position);
    }

    public int getLeftBoundary(){
        return this.leftBoundary;
    }

    public int getRightBoundary(){
        return this.rightBoundary;
    }

    public int getUpperBoundary(){
        return this.upperBoundary;
    }

    public int getLowerBoundary(){
        return this.lowerBoundary;
    }

    private void updateBoundaries(Vector2d newPosition) {
        if (xElements.first().equals(newPosition)) {
            leftBoundary = newPosition.x;
        }
        if (xElements.last().equals(newPosition)) {
            rightBoundary = newPosition.x;
        }
        if (yElements.first().equals(newPosition)) {
            lowerBoundary = newPosition.y;
        }
        if (yElements.last().equals(newPosition)) {
            upperBoundary = newPosition.y;
        }
    }
}
