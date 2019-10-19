package agh.cs.lab3;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
       return "(" + this.x + "," + this.y + ")";
    }

    public boolean precedes(Vector2d other){
        return (this.x <= other.x && this.y <= other.y);
    }

    public boolean follows(Vector2d other){
        return (this.x >= other.x && this.y >= other.y);
    }

    public Vector2d upperRight(Vector2d other){
        int up;
        int right;
        if(this.y >= other.y)
            up = this.y;
        else
            up = other.y;

        if(this.x >= other.x)
            right = this.x;
        else
            right = other.x;

        return new Vector2d(right, up);
    }

    public Vector2d lowerLeft(Vector2d other){
        int down;
        int left;
        if(this.y <= other.y)
            down = this.y;
        else
            down = other.y;

        if(this.x <= other.x)
            left = this.x;
        else
            left = other.x;

        return new Vector2d(left, down);
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d subtract(Vector2d other){
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    public boolean equals(Object other){
        if(this == other)
            return true;
        if(!(other instanceof Vector2d))
            return false;

        Vector2d that = (Vector2d) other;
        return (this.x == that.x && this.y == that.y);
    }

    public Vector2d opposite(){
        return new Vector2d(-this.x, -this.y);
    }
}
