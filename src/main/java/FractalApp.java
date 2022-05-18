import io.darrel.fractal.SierpinskiTriangle;

import javax.swing.*;

public class FractalApp {

    public static void main(String[] arguments) {
        SwingUtilities.invokeLater(FractalApp::createAndShowGui);
    }

    private static void createAndShowGui() {
        var frame = new JFrame("Fractalizr");
        var graphicsPanel = new GraphicsPanel(240, 240, new SierpinskiTriangle(240, 240));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(graphicsPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
