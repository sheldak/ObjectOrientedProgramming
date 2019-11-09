package agh.cs.lab6;

public class RectangularMap extends AbstractWorldMap {
    private int width;
    private int height;

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);

        return mapVisualizer.draw(new Vector2d(0,0), new Vector2d(this.width-1, this.height-1));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        Vector2d v_0_0 = new Vector2d(0, 0);
        Vector2d v_w_h = new Vector2d(this.width-1, this.height-1);

        return position.follows(v_0_0) && position.precedes(v_w_h) && !this.isOccupied(position);
    }
}
