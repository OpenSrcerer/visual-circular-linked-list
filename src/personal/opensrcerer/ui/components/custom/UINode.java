package personal.opensrcerer.ui.components.custom;

import personal.opensrcerer.ui.styling.Painter;

import java.awt.*;
import javax.swing.JPanel;

public class UINode extends JPanel {
    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        // Draw Tree Here
        graphics.drawOval(5, 5, 25, 25);
        Painter.paintBase(this);
    }
}