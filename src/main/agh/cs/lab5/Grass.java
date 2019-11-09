package agh.cs.lab5;

import java.util.Random;

public class Grass implements IMapElement{
    private Vector2d position;

    public Grass(int x, int y){
        this.position = new Vector2d(x, y);
    }

    public String toString(){
        return "*";
    }

    public static void place_grass(GrassField map, int amount){
        while(amount > 0){
            int pos_x;
            int pos_y;
            boolean in;
            do{
                in = false;
                pos_x = new Random().nextInt(map.size);
                pos_y = new Random().nextInt(map.size);
                Vector2d position = new Vector2d(pos_x, pos_y);

                for (IMapElement element: map.elements){
                    if (element.getPosition().equals(position)) {
                        in = true;
                        break;
                    }
                }
            }while(in);

            map.elements.add(new Grass(pos_x, pos_y));

            amount -= 1;
        }
    }

    public Vector2d getPosition(){
        return this.position;
    }
}
