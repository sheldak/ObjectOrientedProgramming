package agh.cs.lab3;

public class Animal {
    private MapDirection animalDirection;
    private Vector2d position;

    public Animal(){
        animalDirection = MapDirection.NORTH;
        position = new Vector2d(2, 2);
    }

    public String toString(){
        return "(" + this.position.x + ", " + this.position.y + ", " + animalDirection.toString() + ")";
    }

    public void move(MoveDirection direction){
        Vector2d newPosition;
        switch(direction) {
            case FORWARD:
                newPosition = position.add(animalDirection.toUnitVector());
                if(newPosition.x >= 0 && newPosition.x <= 4 && newPosition.y >= 0 && newPosition.y <= 4)
                    position = newPosition;
                break;
            case RIGHT:
                animalDirection = animalDirection.next();
                break;
            case BACKWARD:
                newPosition = position.subtract(animalDirection.toUnitVector());
                if(newPosition.x >= 0 && newPosition.x <= 4 && newPosition.y >= 0 && newPosition.y <= 4)
                    position = newPosition;
                break;
            case LEFT:
                animalDirection = animalDirection.previous();
                break;
        }
    }
}
