package assignment9;

import java.awt.Color;
import java.util.Random;
import edu.princeton.cs.introcs.StdDraw;

public class Food {
    public static final double FOOD_SIZE = 0.02;
    private double x, y;
    private Color color;

    public Food() {
        Random rand = new Random();
        this.x = rand.nextDouble();
        this.y = rand.nextDouble();
        this.color = ColorUtils.solidColor();
    }

    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(x, y, FOOD_SIZE / 2);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
