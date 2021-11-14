package personal.opensrcerer.ui.components.custom;

import personal.opensrcerer.ui.styling.Painter;

import java.awt.*;
import javax.swing.JPanel;

public class SuiciderNode extends JPanel {

    private static final int NODE_SIZE = 26;

    private final Point location;

    public SuiciderNode(int x, int y) {
        this.setLocation(x, y);
        this.setSize(NODE_SIZE + 1, NODE_SIZE + 1);
        this.location = new Point(x, y);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawOval(0, 0, NODE_SIZE, NODE_SIZE);
        Painter.paintBase(this);
    }

    public int centerX() {
        return location.x + 13;
    }

    public int centerY() {
        return location.y + 13;
    }
}