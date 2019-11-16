package agh.cs.lab7;

import java.util.ArrayList;
import java.util.List;

public class Animal implements IMapElement{
    private MapDirection animalDirection;
    private Vector2d position;
    private AbstractWorldMap map;

    private List<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(AbstractWorldMap map){
        this.animalDirection = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
        this.map = map;
    }

    public Animal(AbstractWorldMap map, int x, int y){
        this.animalDirection = MapDirection.NORTH;
        this.position = new Vector2d(x, y);
        this.map = map;
    }

    public String toString(){
        switch(animalDirection){
            case NORTH:
                return "N";
            case EAST:
                return "E";
            case SOUTH:
                return "S";
            case WEST:
                return "W";
            default:
                return "Error";
        }
    }

    public void move(MoveDirection direction){
        Vector2d destination;
        switch(direction) {
            case FORWARD:
                destination = this.position.add(this.animalDirection.toUnitVector());
                this.moveTo(destination);
                break;
            case RIGHT:
                animalDirection = animalDirection.next();
                break;
            case BACKWARD:
                destination = this.position.add(this.animalDirection.toUnitVector().opposite());
                this.moveTo(destination);
                break;
            case LEFT:
                animalDirection = animalDirection.previous();
                break;
        }
    }

    private void moveTo(Vector2d destination){
        if(this.map.canMoveTo(destination)) {
            if(this.map instanceof GrassField)
                ((GrassField) map).consumeGrass(destination);

            this.positionChanged(this.getPosition(), destination);
            this.position = destination;
        }
    }

    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer : observers)
            observer.positionChanged(oldPosition, newPosition);
    }

    public Vector2d getPosition(){
        return this.position;
    }
}
