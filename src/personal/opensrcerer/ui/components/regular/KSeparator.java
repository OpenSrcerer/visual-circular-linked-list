/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

package personal.opensrcerer.ui.components.regular;

import personal.opensrcerer.ui.styling.DiscordColor;

import javax.swing.*;

/**
 * A Discord-themed JSeparator.
 */
public class KSeparator extends JSeparator {

    /**
     * Create a new KSeparator.
     */
    public KSeparator() {
        this(SwingConstants.HORIZONTAL);
    }

    /**
     * Craete a new KSeparator with a specific orientation.
     * @param swingConstant The specific orientation of this separator.
     */
    public KSeparator(int swingConstant) {
        super(swingConstant);
        this.setForeground(DiscordColor.blurple.get());
        this.setBackground(DiscordColor.blurple.get());
        this.setOpaque(true);
    }
}
