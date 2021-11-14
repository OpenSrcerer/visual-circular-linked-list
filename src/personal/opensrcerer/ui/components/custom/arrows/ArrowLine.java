package personal.opensrcerer.ui.components.custom.arrows;

import personal.opensrcerer.ui.components.custom.SuiciderNode;
import personal.opensrcerer.ui.styling.Painter;

import javax.swing.*;
import java.awt.*;

public class ArrowLine extends JPanel {

    private final Point origin;
    private final Point target;

    public ArrowLine(SuiciderNode origin, SuiciderNode target) {
        this.setSize(1000, 1000);
        this.setBackground(Color.RED);
        this.origin = new Point(origin.centerX(), origin.centerY());
        this.target = new Point(target.centerX(), target.centerY());
    }

    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawLine(origin.x, origin.y, target.x, target.y);
        Painter.paintBase(this);
    }
}
