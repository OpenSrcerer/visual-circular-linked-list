package personal.opensrcerer.ui.styling;

import java.awt.*;

/**
 * An enum that shows the available colors
 * for the UI. Inspired by the Discord theme.
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

    regularGrayTransparent(new Color(54, 57, 63)),

    dndTransparent(new Color(1f, 0f, 0f, 0.75f)),
    dndMoreTransparent(new Color(1f, 0f, 0f, 0.35f));

    private final Color color;

    DiscordColor(Color color) {
        this.color = color;
    }

    public Color get() {
        return this.color;
    }
}
