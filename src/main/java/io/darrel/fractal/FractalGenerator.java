package io.darrel.fractal;

import java.awt.*;

public interface FractalGenerator {
    int getX();
    int getY();
    Color getColor();
    void generateNext();
}
