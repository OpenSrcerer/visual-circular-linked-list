package personal.opensrcerer.ui.styling;

import java.awt.*;

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

    private final Stroke stroke;

    Strokes(Stroke stroke) {
        this.stroke = stroke;
    }

    public Stroke get() {
        return stroke;
    }
}
