package agh.cs.lab6;

import java.util.Random;

public class Grass implements IMapElement{
    private Vector2d position;

    public Grass(int x, int y){
        this.position = new Vector2d(x, y);
    }

    public String toString(){
        return "*";
    }

    public static void placeGrass(GrassField map, int amount){
        while(amount > 0){
            int posX;
            int posY;
            boolean in;
            do{
                in = false;
                posX = new Random().nextInt(map.size);
                posY = new Random().nextInt(map.size);
                Vector2d position = new Vector2d(posX, posY);

                if(map.isOccupied(position)){
                    in = true;
                    break;
                }

            } while(in);

            Grass grass = new Grass(posX, posY);
            map.elementsMap.put(new Vector2d(posX, posY), grass);
            map.grasses.add(grass);

            amount -= 1;
        }
    }

    public Vector2d getPosition(){
        return this.position;
    }
}

