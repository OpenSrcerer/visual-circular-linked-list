/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

package personal.opensrcerer.ui.components.regular;

import personal.opensrcerer.ui.styling.DiscordColor;
import personal.opensrcerer.ui.styling.Painter;

import javax.swing.*;
import java.awt.*;

/**
 * A discord-themed JPanel.
 */
public class KPanel extends JPanel {

    /**
     * Create a new KPanel with a custom LayoutManager and background color.
     * @param manager Custom manager this KPanel should have.
     * @param color Custom color this KPanel should have.
     */
    public KPanel(LayoutManager manager, DiscordColor color) {
        super(manager);
        this.setBackground(color.get());
    }

    /**
     * Create a new KPanel with a new BoxLayout, a specific arrangement,
     * and a custom color.
     * @param layout The specific BoxLayout value that depicts how to
     *               arrange elements.
     * @param color The background color of this component.
     */
    public KPanel(int layout, DiscordColor color) {
        super();
        this.setLayout(new BoxLayout(this, layout));
        this.setBackground(color.get());
    }

    /**
     * Create a new KPanel with a custom LayoutManager.
     * @param manager Custom manager this KPanel should have.
     */
    public KPanel(LayoutManager manager) {
        super(manager);
        Painter.paintBase(this);
    }

    /**
     * Create a new KPanel with a new BoxLayout and a specific arrangement.
     * @param layout The specific BoxLayout value that depicts how to
     *               arrange elements.
     */
    public KPanel(int layout) {
        this();
        this.setLayout(new BoxLayout(this, layout));
    }

    /**
     * Create a new KPanel with a FlowLayout and regular background
     * palette.
     */
    public KPanel() {
        super();
        Painter.paintBase(this);
    }
}
