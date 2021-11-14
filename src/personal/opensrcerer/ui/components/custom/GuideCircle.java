package personal.opensrcerer.ui.components.custom;

import personal.opensrcerer.ui.styling.Painter;

import javax.swing.*;
import java.awt.*;

public class GuideCircle extends JPanel {

    private static final int CIRCLE_X = 500;
    private static final int CIRCLE_Y = 500;

    public GuideCircle() {
        this.setSize(new Dimension(CIRCLE_X + 1, CIRCLE_Y + 1));
        Painter.paintBase(this);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.drawOval(0, 0, CIRCLE_X, CIRCLE_Y);
        Painter.paintBase(this);
    }
}
