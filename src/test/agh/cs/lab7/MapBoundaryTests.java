package agh.cs.lab7;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

public class MapBoundaryTests {
    private Comparator<Vector2d> xComparator = Comparator.comparing(Vector2d::getX).thenComparing(Vector2d::getY);
    private Comparator<Vector2d> yComparator = Comparator.comparing(Vector2d::getY).thenComparing(Vector2d::getX);

    private TreeSet<Vector2d> xElements = new TreeSet<>(xComparator);
    private TreeSet<Vector2d> yElements = new TreeSet<>(yComparator);

    private Vector2d vector_1_1 = new Vector2d(1, 1);
    private Vector2d vector_2_2 = new Vector2d(2, 2);
    private Vector2d vector_1_2 = new Vector2d(1, 2);
    private Vector2d vector_2_1 = new Vector2d(2, 1);

    @Test
    void addObjectTest(){
        this.xElements.add(vector_1_1);
        this.xElements.add(vector_2_2);

        this.yElements.add(vector_1_1);
        this.yElements.add(vector_2_2);

        assertEquals(xElements.first(), vector_1_1);
        assertEquals(xElements.last(), vector_2_2);
        assertEquals(yElements.first(), vector_1_1);
        assertEquals(yElements.last(), vector_2_2);

        this.xElements.add(vector_1_2);
        this.xElements.add(vector_2_1);

        this.yElements.add(vector_1_2);
        this.yElements.add(vector_2_1);

        assertEquals(xElements.first(), vector_1_1);
        assertEquals(xElements.last(), vector_2_2);
        assertEquals(yElements.first(), vector_1_1);
        assertEquals(yElements.last(), vector_2_2);
    }
}
