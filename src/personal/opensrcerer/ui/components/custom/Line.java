/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

package personal.opensrcerer.ui.components.custom;

import personal.opensrcerer.ui.UIConstants;
import personal.opensrcerer.ui.styling.DiscordColor;
import personal.opensrcerer.ui.styling.Strokes;

import javax.swing.*;
import java.awt.*;

/**
 * This is a custom JPanel which has overriden the
 * paintComponent() method in order to display
 * a line, used to connect nodes together.
 */
public class Line extends JPanel {

    /**
     * The (X, Y) point in 2D space for the first point of the line.
     */
    private final Point origin;

    /**
     * The (X, Y) point in 2D space for the second point of the line.
     */
    private final Point target;

    /**
     * Create a new Line given the origin and target positions.
     * @param origin The origin point for the line.
     * @param target The target point for the line.
     */
    public Line(SuiciderNode origin, SuiciderNode target) {
        this.setSize(1000, 1000);
        this.setBackground(Color.RED);
        this.origin = new Point(
                origin.centerX() + UIConstants.NODE_STROKE_OFFSET,
                origin.centerY() + UIConstants.NODE_STROKE_OFFSET
        );
        this.target = new Point(
                target.centerX() + UIConstants.NODE_STROKE_OFFSET,
                target.centerY() + UIConstants.NODE_STROKE_OFFSET
        );
        this.setForeground(DiscordColor.blurple.get());
    }

    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(Strokes.DASHED_LINE_STROKE.get());
        g2d.drawLine(origin.x, origin.y, target.x, target.y);
    }
}
