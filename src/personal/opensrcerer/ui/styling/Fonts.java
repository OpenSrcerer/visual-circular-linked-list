/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

package personal.opensrcerer.ui.styling;

import java.awt.*;

public enum Fonts {

    /**
     * Font used for messages to the player.
     */
    bigTitleFont(new Font("Century Gothic", Font.BOLD, 30)),

    /**
     * Font used for nodes
     */
    nodeFont(new Font("Courier", Font.BOLD, 30)),

    /**
     * Used for large buttons, etc.
     */
    titleFont(new Font("Century Gothic", Font.PLAIN, 20)),

    /**
     * Used for text fields.
     */
    textFieldFont(new Font("Arial", Font.PLAIN, 30)),

    /**
     * Used for explanatory messages.
     */
    descriptionFont(new Font("Arial", Font.ITALIC, 25));

    /**
     * The Font object for every enum instance.
     */
    private final Font font;

    /**
     * @param font The Font type this enum instance should have.
     */
    Fonts(Font font) {
        this.font = font;
    }

    /**
     * @return The Font object for this enum instance.
     */
    public Font get() {
        return this.font;
    }
}
