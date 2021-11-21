/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

package personal.opensrcerer.ui.styling;

import java.awt.*;

/**
 * An enum that shows the available colors
 * for the UI. Inspired by the Discord application theme.
 */
public enum DiscordColor {
    lightGray(new Color(185, 187, 190)),
    lessGray(new Color(71, 71, 71)),
    regularGray(new Color(54, 57, 63)),
    grayest(new Color(47, 49, 54)),
    blurple(new Color(78, 93, 148)),
    purple(new Color(138, 43, 226)),
    darkPurple(new Color(60, 48, 73)),
    online(new Color(50, 217, 28)),

    blurpleTransparent(new Color(78, 93, 148, 140)),
    lightGrayTransparent(new Color(185, 187, 190, 140)),
    regularGrayTransparent(new Color(54, 57, 63, 140)),

    dndTransparent(new Color(1f, 0f, 0f, 0.75f)),
    dndMoreTransparent(new Color(1f, 0f, 0f, 0.35f));

    /**
     * The color object of this enum.
     */
    private final Color color;

    /**
     * Create a new DiscordColor with a specific Color object.
     * @param color Color to contain.
     */
    DiscordColor(Color color) {
        this.color = color;
    }

    /**
     * @return The Color object of this enum.
     */
    public Color get() {
        return this.color;
    }
}
