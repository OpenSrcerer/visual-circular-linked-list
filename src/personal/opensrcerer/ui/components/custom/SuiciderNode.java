package personal.opensrcerer.ui.components.custom;

import personal.opensrcerer.ui.UIConstants;
import personal.opensrcerer.ui.components.events.NodeMouseAdapter;
import personal.opensrcerer.ui.styling.DiscordColor;
import personal.opensrcerer.ui.styling.Fonts;
import personal.opensrcerer.ui.styling.Painter;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

import static personal.opensrcerer.ui.UIConstants.BASE_NODE_SIZE;

public class SuiciderNode extends JButton {

    private DiscordColor color;
    private final Point location;
    private final String name;

    public SuiciderNode(int x, int y, String name) {
        this.color = DiscordColor.blurple;
        this.setLocation(x, y);
        this.setSize(BASE_NODE_SIZE + 8, BASE_NODE_SIZE + 8);
        this.location = new Point(x, y);
        this.name = name;

        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setBorderPainted(false);
        this.addMouseListener(new NodeMouseAdapter(this));
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        drawNodeFill(g2d);
        drawNodeOutline(g2d, this.color.get());
        drawNodeLetter(g2d);
    }

    private void drawNodeFill(Graphics2D g2d) {
        g2d.setColor(DiscordColor.lightGray.get());
        Ellipse2D.Double circle = new Ellipse2D.Double(
                UIConstants.STROKE_NODE_OFFSET, UIConstants.STROKE_NODE_OFFSET,
                BASE_NODE_SIZE, BASE_NODE_SIZE);
        g2d.fill(circle);
    }

    private void drawNodeOutline(Graphics2D g2d, Color color) {
        g2d.setColor(color);
        g2d.setStroke(Painter.NODE_STROKE);
        g2d.drawOval(UIConstants.STROKE_NODE_OFFSET, UIConstants.STROKE_NODE_OFFSET,
                BASE_NODE_SIZE, BASE_NODE_SIZE);
    }

    private void drawNodeLetter(Graphics2D g2d) {
        g2d.setColor(
                (isKitsos() ? Color.RED.darker() :
                DiscordColor.regularGray.get()
        ));
        g2d.setFont(Fonts.nodeFont.get());
        g2d.drawString(name.substring(0, 1),
                (BASE_NODE_SIZE / 2) - UIConstants.STROKE_NODE_OFFSET,
                BASE_NODE_SIZE - UIConstants.STROKE_NODE_OFFSET);
    }

    public void setColor(DiscordColor color) {
        this.color = color;
    }

    public boolean isKitsos() {
        return name.equals("Kitsos");
    }

    public String name() {
        return name;
    }

    public int centerX() {
        return location.x + BASE_NODE_SIZE / 2;
    }

    public int centerY() {
        return location.y + BASE_NODE_SIZE / 2;
    }
}