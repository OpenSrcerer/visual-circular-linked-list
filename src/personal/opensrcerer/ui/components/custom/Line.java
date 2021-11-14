package personal.opensrcerer.ui.components.custom;

import personal.opensrcerer.ui.UIConstants;
import personal.opensrcerer.ui.styling.DiscordColor;
import personal.opensrcerer.ui.styling.Painter;

import javax.swing.*;
import java.awt.*;

public class Line extends JPanel {

    private final Point origin;
    private final Point target;

    public Line(SuiciderNode origin, SuiciderNode target) {
        this.setSize(1000, 1000);
        this.setBackground(Color.RED);
        this.origin = new Point(
                origin.centerX() + UIConstants.STROKE_NODE_OFFSET,
                origin.centerY() + UIConstants.STROKE_NODE_OFFSET
        );
        this.target = new Point(
                target.centerX() + UIConstants.STROKE_NODE_OFFSET,
                target.centerY() + UIConstants.STROKE_NODE_OFFSET
        );
        this.setForeground(DiscordColor.blurple.get());
    }

    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(Painter.DASHED_LINE_STROKE);
        g2d.drawLine(origin.x, origin.y, target.x, target.y);
    }
}
