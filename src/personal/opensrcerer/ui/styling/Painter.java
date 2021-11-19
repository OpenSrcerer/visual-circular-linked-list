package personal.opensrcerer.ui.styling;

import java.awt.*;

/**
 * This class is used to paint components with predefined colors
 * to match the ambiance and theme of the UI.
 */
public abstract class Painter {

    /**
     * Paints the base colors of any component.
     * @param component Component to paint.
     */
    public static void paintBase(Component component) {
        component.setBackground(DiscordColor.grayest.get());
        component.setForeground(DiscordColor.lightGray.get());
    }
}
