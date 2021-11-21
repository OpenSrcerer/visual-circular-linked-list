/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

package personal.opensrcerer.ui.styling;

import java.awt.*;

/**
 * A theme enum that denotes the stroke that the
 * graphics component should use for drawing.
 */
public enum Strokes {
    DASHED_LINE_STROKE(new BasicStroke(
            3.5f,
            BasicStroke.CAP_ROUND,
            BasicStroke.JOIN_MITER,
            10.0f,
            new float[] {10.0f},
            0.0f
    )),
    NODE_STROKE(new BasicStroke(
            3.5f,
            BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_MITER,
            10.0f
    )),
    NODE_STROKE_KITSOS(new BasicStroke(
            3.5f,
            BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_MITER,
            10.0f
    )),
    ARROW_STROKE(new BasicStroke(
            7f,
            BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_MITER,
            10.0f
    ));

    /**
     * The Stroke of this object.
     */
    private final Stroke stroke;

    /**
     * @param stroke The Stroke object for this enum.
     */
    Strokes(Stroke stroke) {
        this.stroke = stroke;
    }

    /**
     * @return The Stroke object of the enum.
     */
    public Stroke get() {
        return stroke;
    }
}
