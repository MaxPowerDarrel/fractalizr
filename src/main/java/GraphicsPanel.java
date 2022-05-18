import io.darrel.fractal.FractalGenerator;

import javax.swing.*;
import java.awt.*;

public class GraphicsPanel extends JPanel {
    private int x;
    private int y;
    private Color color;
    private final int width;
    private final int height;
    private final FractalGenerator fractalGenerator;

    public GraphicsPanel(int width, int height, FractalGenerator fractalGenerator) {
        this.width = width;
        this.height = height;
        this.fractalGenerator = fractalGenerator;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.drawFractal();
    }

    private void drawFractal() {
        var timer = new Timer(0, event -> {
            x = fractalGenerator.getX();
            y = fractalGenerator.getY();
            color = fractalGenerator.getColor();
            fractalGenerator.generateNext();
            repaint(x, y, 1, 1);
        });
        timer.setDelay(1);
        timer.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(x, y, 1, 1);
    }
}
