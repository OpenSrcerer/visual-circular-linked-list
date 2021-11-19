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

    private final Font font;

    Fonts(Font font) {
        this.font = font;
    }

    public Font get() {
        return this.font;
    }
}
