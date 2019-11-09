package agh.cs.lab6;

public class Animal implements IMapElement{
    private MapDirection animalDirection;
    private Vector2d position;
    private IWorldMap map;

    public Animal(){
        this.animalDirection = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }

    public Animal(IWorldMap map){
        this.animalDirection = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
        this.map = map;
    }

    public Animal(IWorldMap map, int x, int y){
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
        switch(direction) {
            case FORWARD:
                if(this.map.canMoveTo(this.position.add(this.animalDirection.toUnitVector())))
                    this.position = this.position.add(this.animalDirection.toUnitVector());
                break;
            case RIGHT:
                animalDirection = animalDirection.next();
                break;
            case BACKWARD:
                if(this.map.canMoveTo(this.position.add(this.animalDirection.toUnitVector().opposite())))
                    this.position = this.position.add(this.animalDirection.toUnitVector().opposite());
                break;
            case LEFT:
                animalDirection = animalDirection.previous();
                break;
        }
    }

    public Vector2d getPosition(){
        return this.position;
    }
}
