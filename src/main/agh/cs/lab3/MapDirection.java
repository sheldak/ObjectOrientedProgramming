package agh.cs.lab3;

import java.util.Map;

enum MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public String toString(){
        switch(this){
            case NORTH:
                return "Północ";
            case SOUTH:
                return "Południe";
            case EAST:
                return "Wschód";
            case WEST:
                return "Zachód";
            default:
                return "Error";
        }
    }

    public MapDirection next(){
        return MapDirection.values()[(this.ordinal() + 1) % MapDirection.values().length];
    }

    public MapDirection previous(){
        return MapDirection.values()[(this.ordinal() + 3) % MapDirection.values().length];
    }

    public Vector2d toUnitVector() {
        switch(this){
            case NORTH:
                return new Vector2d(0, 1);
            case EAST:
                return new Vector2d(1, 0);
            case SOUTH:
                return new Vector2d(0,-1);
            case WEST:
                return new Vector2d(-1, 0);
        }
        return null;
    }
}
