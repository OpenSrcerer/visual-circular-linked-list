package personal.opensrcerer.ui.components.regular;

import personal.opensrcerer.ui.styling.Colors;

import javax.swing.*;

/**
 * A Discord-themed JSeparator.
 */
public class KSeparator extends JSeparator {
    public KSeparator() {
        super();
        this.setForeground(Colors.discordBlurple.get());
        this.setBackground(Colors.discordBlurple.get());
        this.setOpaque(true);
    }
}
