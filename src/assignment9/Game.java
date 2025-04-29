package assignment9;

import java.awt.Color;
import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;

public class Game {
    private Snake snake;
    private Food food;
    private int score = 0;

    public Game() {
        StdDraw.setCanvasSize(600, 600);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        StdDraw.enableDoubleBuffering();

        snake = new Snake();
        food = new Food();
    }

    public void play() {
    	StdDraw.clear();
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(0.5, 0.6, "🐍 Welcome to Snake Game 🐍");
        StdDraw.text(0.5, 0.4, "Press any key to start...");
        StdDraw.show();

        while (!StdDraw.hasNextKeyTyped()) {
            StdDraw.pause(50);
        }
        StdDraw.nextKeyTyped(); 
        while (true) {
            int dir = getKeypress();
            if (dir != -1) {
                snake.changeDirection(dir);
            }

            snake.move();

            if (snake.eatFood(food)) {
                food = new Food();
                score++;
            }

            updateDrawing();

            if (!snake.isInBounds()) {
                StdDraw.clear();
                StdDraw.setPenColor(Color.RED);
                StdDraw.text(0.5, 0.6, "Game Over!");
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.text(0.5, 0.4, "Final Score: " + score);
                StdDraw.show();
                break;
            }
        }
    }

    private int getKeypress() {
        if (StdDraw.isKeyPressed(KeyEvent.VK_W)) return 1;
        if (StdDraw.isKeyPressed(KeyEvent.VK_S)) return 2;
        if (StdDraw.isKeyPressed(KeyEvent.VK_A)) return 3;
        if (StdDraw.isKeyPressed(KeyEvent.VK_D)) return 4;
        return -1;
    }

    private void updateDrawing() {
        StdDraw.clear();
        snake.draw();
        food.draw();
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.textLeft(0.02, 0.98, "Score: " + score);
        StdDraw.pause(40);
        StdDraw.show();
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.play();
    }
}
