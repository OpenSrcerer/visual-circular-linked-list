package personal.opensrcerer.ui.components.regular;

import personal.opensrcerer.ui.styling.DiscordColor;

import javax.swing.*;

/**
 * A Discord-themed JSeparator.
 */
public class KSeparator extends JSeparator {
    public KSeparator() {
        super();
        this.setForeground(DiscordColor.blurple.get());
        this.setBackground(DiscordColor.blurple.get());
        this.setOpaque(true);
    }
}
