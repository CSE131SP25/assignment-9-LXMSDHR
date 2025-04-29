package assignment9;

import java.util.LinkedList;

public class Snake {
    private static final double SEGMENT_SIZE = 0.02;
    private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;

    private LinkedList<BodySegment> segments;
    private double deltaX;
    private double deltaY;

    public Snake() {
        segments = new LinkedList<>();
        segments.add(new BodySegment(0.5, 0.5, SEGMENT_SIZE));
        deltaX = MOVEMENT_SIZE; 
        deltaY = 0;
    }


    public void changeDirection(int direction) {
        if (direction == 1) { 
            deltaX = 0;
            deltaY = MOVEMENT_SIZE;
        } else if (direction == 2) { 
            deltaX = 0;
            deltaY = -MOVEMENT_SIZE;
        } else if (direction == 3) {
            deltaX = -MOVEMENT_SIZE;
            deltaY = 0;
        } else if (direction == 4) { 
            deltaX = MOVEMENT_SIZE;
            deltaY = 0;
        }
    }

    public void move() {
        BodySegment head = segments.getFirst();
        double newX = head.getX() + deltaX;
        double newY = head.getY() + deltaY;
        segments.addFirst(new BodySegment(newX, newY, SEGMENT_SIZE));
        segments.removeLast(); 
    }

    public void draw() {
        System.out.println("Snake is drawing...");
        for (BodySegment segment : segments) {
            segment.draw();
        }
    }

    public boolean eatFood(Food f) {
        BodySegment head = segments.getFirst();
        double distance = Math.sqrt(Math.pow(head.getX() - f.getX(), 2) + Math.pow(head.getY() - f.getY(), 2));
        if (distance < (SEGMENT_SIZE + Food.FOOD_SIZE) / 2) {
            BodySegment newHead = new BodySegment(head.getX() + deltaX, head.getY() + deltaY, SEGMENT_SIZE);
            segments.addFirst(newHead);
            return true;
        }
        return false;
    }

    public boolean isInBounds() {
        BodySegment head = segments.getFirst();
        double x = head.getX();
        double y = head.getY();
        return x >= 0 && x <= 1 && y >= 0 && y <= 1;
    }
}
