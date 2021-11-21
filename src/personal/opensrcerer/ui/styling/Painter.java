/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

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
