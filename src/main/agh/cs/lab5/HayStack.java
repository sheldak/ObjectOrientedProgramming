package agh.cs.lab5;

public class HayStack implements IMapElement{
    private Vector2d position;

    public HayStack(int x, int y){
        this.position = new Vector2d(x, y);

    }

    public String toString(){
        return "s";
    }

    public Vector2d getPosition(){
        return this.position;
    }
}
