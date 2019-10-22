package agh.cs.lab3;

public class Animal {
    private MapDirection animalDirection;
    private Vector2d position;

    public Animal(){
        this.animalDirection = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }

    public String toString(){
        return "(" + this.position.x + ", " + this.position.y + ", " + this.animalDirection.toString() + ")";
    }

    public void move(MoveDirection direction){
        Vector2d v_0_0 = new Vector2d(0, 0);
        Vector2d v_3_3 = new Vector2d(4, 4);

        switch(direction) {
            case FORWARD:
                Vector2d forwardVector = this.position.add(this.animalDirection.toUnitVector());
                if(v_0_0.precedes(forwardVector) && v_3_3.follows(forwardVector))
                    this.position = forwardVector;
                break;
            case RIGHT:
                this.animalDirection = this.animalDirection.next();
                break;
            case BACKWARD:
                Vector2d backwardVector = this.position.subtract(this.animalDirection.toUnitVector());
                if(v_0_0.precedes(backwardVector) && v_3_3.follows(backwardVector))
                    this.position = backwardVector;
                break;
            case LEFT:
                this.animalDirection = this.animalDirection.previous();
                break;
        }
    }
}
