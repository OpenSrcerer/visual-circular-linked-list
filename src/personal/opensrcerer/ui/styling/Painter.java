package personal.opensrcerer.ui.styling;

import java.awt.*;

/**
 * This class is used to paint components with predefined colors
 * to match the ambiance and theme of the UI.
 *
 * Note: Any mention of "custom" in the methods of this class
 * refers to the description above.
 */
public abstract class Painter {
    public static final Stroke DASHED_LINE_STROKE = new BasicStroke(
            3.5f,
            BasicStroke.CAP_ROUND,
            BasicStroke.JOIN_MITER,
            10.0f,
            new float[] {10.0f},
            0.0f
    );

    public static final Stroke NODE_STROKE = new BasicStroke(
            3.5f,
            BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_MITER,
            10.0f
    );

    public static final Stroke NODE_STROKE_KITSOS = new BasicStroke(
            3.5f,
            BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_MITER,
            10.0f
    );

    /**
     * Paints the base colors of any component.
     * @param component Component to paint.
     */
    public static void paintBase(Component component) {
        component.setBackground(DiscordColor.regularGray.get());
        component.setForeground(DiscordColor.lightGray.get());
    }
}
