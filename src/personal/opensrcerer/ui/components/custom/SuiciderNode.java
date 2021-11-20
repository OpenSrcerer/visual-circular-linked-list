package personal.opensrcerer.ui.components.custom;

import personal.opensrcerer.entities.Suicider;
import personal.opensrcerer.ui.UIConstants;
import personal.opensrcerer.ui.components.events.NodeMouseAdapter;
import personal.opensrcerer.ui.styling.DiscordColor;
import personal.opensrcerer.ui.styling.Fonts;
import personal.opensrcerer.ui.styling.Strokes;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

import static personal.opensrcerer.ui.UIConstants.*;

public class SuiciderNode extends JButton {

    private final Point location;
    private final Suicider suicider;

    private boolean dead;
    private boolean hover;

    public SuiciderNode(
            int x,
            int y,
            Suicider suicider
    ) {
        this.suicider = suicider;
        this.location = new Point(x, y);

        this.hover = false;
        this.setLocation(x, y);
        this.setSize(NODE_FULL_SIZE, NODE_FULL_SIZE);
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
        drawNodeOutline(g2d);
        drawNodeLetter(g2d);

        if (this.isDead()) {
            drawDeathCross(g2d, this.hover);
        }
    }

    private void drawNodeFill(Graphics2D g2d) {
        this.setFillColor(g2d);
        Ellipse2D.Double circle = new Ellipse2D.Double(
                UIConstants.NODE_STROKE_OFFSET, UIConstants.NODE_STROKE_OFFSET,
                NODE_BASE_SIZE, NODE_BASE_SIZE);
        g2d.fill(circle);
    }

    private void drawNodeOutline(Graphics2D g2d) {
        this.setOutlineColor(g2d);
        if (this.hover) {
            g2d.setColor(DiscordColor.purple.get());
        }
        g2d.setStroke((isKitsos() ? Strokes.NODE_STROKE_KITSOS.get() :
                Strokes.NODE_STROKE.get()));
        g2d.drawOval(UIConstants.NODE_STROKE_OFFSET, UIConstants.NODE_STROKE_OFFSET,
                NODE_BASE_SIZE, NODE_BASE_SIZE);
    }

    private void drawNodeLetter(Graphics2D g2d) {
        this.setLetterColor(g2d);
        g2d.setFont(Fonts.nodeFont.get());
        g2d.drawString(this.name().substring(0, 1),
                (NODE_BASE_SIZE / 2) - UIConstants.NODE_FONT_HORIZONTAL_OFFSET,
                NODE_BASE_SIZE - UIConstants.NODE_FONT_VERTICAL_OFFSET);
    }

    private void drawDeathCross(Graphics2D g2d, boolean hover) {
        g2d.setPaint(hover ? DiscordColor.dndMoreTransparent.get() : DiscordColor.dndTransparent.get());
        g2d.drawLine(NODE_SIZE_PADDING + 1,
                NODE_SIZE_PADDING + 1,
                NODE_BASE_SIZE + 1,
                NODE_BASE_SIZE + 1
        );
        g2d.drawLine(NODE_BASE_SIZE,
                NODE_SIZE_PADDING,
                NODE_SIZE_PADDING,
                NODE_BASE_SIZE
        );
    }

    private void setFillColor(Graphics2D g2d) {
        g2d.setColor(DiscordColor.lightGray.get());
        if (isKitsos())
            g2d.setPaint(DiscordColor.grayest.get());
        else if (isDead())
            g2d.setPaint(DiscordColor.lightGrayTransparent.get());
        if (hover && !isKitsos())
            g2d.setPaint(DiscordColor.lightGray.get());
    }

    private void setOutlineColor(Graphics2D g2d) {
        g2d.setColor(DiscordColor.blurple.get());
        if (isKitsos())
            g2d.setPaint(DiscordColor.online.get());
        else if (isDead())
            g2d.setPaint(DiscordColor.blurpleTransparent.get());
        if (hover && !isKitsos())
            g2d.setPaint(DiscordColor.blurple.get());
    }

    private void setLetterColor(Graphics2D g2d) {
        g2d.setColor(DiscordColor.regularGray.get());
        if (isKitsos())
            g2d.setPaint(DiscordColor.lightGray.get());
        else if (isDead())
            g2d.setPaint(DiscordColor.regularGrayTransparent.get());
        if (hover && !isKitsos())
            g2d.setPaint(DiscordColor.regularGray.get());
    }

    public void refresh() {
        this.invalidate();
        this.repaint();
    }

    public int centerX() {
        return this.location.x + NODE_BASE_SIZE / 2;
    }

    public int centerY() {
        return this.location.y + NODE_BASE_SIZE / 2;
    }

    public void setHover(boolean hover) {
        this.hover = hover;
    }

    public void revive() {
        this.dead = false;
        this.refresh();
    }

    public void kill() {
        this.dead = true;
        this.refresh();
    }

    public boolean isDead() {
        return dead;
    }

    public String name() {
        return this.suicider.getName();
    }

    public int position() {
        return this.suicider.getPosition();
    }

    public boolean isKitsos() {
        return this.name().equals("Kitsos");
    }
}