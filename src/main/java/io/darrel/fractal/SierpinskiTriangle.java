package io.darrel.fractal;

import java.awt.*;
import java.util.Random;

public class SierpinskiTriangle implements FractalGenerator {
    private int x;
    private int y;
    private final int width;
    private final int height;

    private final Random random = new Random(System.currentTimeMillis());

    public SierpinskiTriangle(int width, int height) {
        x = width / 2;
        y = height;
        this.height = height;
        this.width = width;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public Color getColor() {
        if (y <= height / 2)
            return Color.RED;
        else if (x >= width / 2)
            return Color.BLUE;
        else return Color.GREEN;
    }

    @Override
    public void generateNext() {
        var moveToSide = random.nextInt(3);
        switch (moveToSide) {
            case 0 -> moveToA();
            case 1 -> moveToB();
            case 2 -> moveToC();
        }
    }

    private void moveToA() {
        x = x / 2;
        y = (y + height) / 2;
    }

    private void moveToB() {
        x = (x + width / 2) / 2;
        y = y / 2;
    }

    private void moveToC() {
        x = (x + height) / 2;
        y = (y + height) / 2;
    }
}
