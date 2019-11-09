package agh.cs.lab6;

public class Animal implements IMapElement{
    private MapDirection animalDirection;
    private Vector2d position;
    private AbstractWorldMap map;

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
            boolean createGrass = false;
            if (this.map.isOccupied(destination)){
                this.map.destroyObject(destination);
                createGrass = true;
            }

            map.elementsMap.remove(this.position);
            this.position = destination;
            map.elementsMap.put(this.position, this);

            if(this.map instanceof GrassField && createGrass)
                Grass.placeGrass((GrassField) map, 1);
        }
    }

    public Vector2d getPosition(){
        return this.position;
    }
}
