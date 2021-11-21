/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

package personal.opensrcerer.ui.components.regular;

import personal.opensrcerer.ui.styling.Painter;
import personal.opensrcerer.ui.styling.Fonts;

import javax.swing.*;
import java.awt.*;

/**
 * A discord-themed JLabel.
 */
public class KLabel extends JLabel {

    /**
     * Create a new KLabel with a custom theme.
     * @param name The name of this KLabel.
     * @param font The Font this KLabel shoud have.
     */
    public KLabel(String name, Fonts font) {
        super(name);
        Painter.paintBase(this);
        this.setFont(font.get());
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
}
