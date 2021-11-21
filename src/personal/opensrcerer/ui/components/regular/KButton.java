/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

package personal.opensrcerer.ui.components.regular;

import personal.opensrcerer.ui.components.events.ButtonClickAdapter;
import personal.opensrcerer.ui.components.events.ButtonMouseAdapter;
import personal.opensrcerer.ui.components.events.ButtonType;
import personal.opensrcerer.ui.styling.DiscordColor;
import personal.opensrcerer.ui.styling.Painter;

import javax.swing.*;
import java.awt.*;

/**
 * A discord-themed JButton.
 */
public class KButton extends KPanel {

    /**
     * Creates a custom JButton.
     * @param text Name and initial text of button.
     */
    public KButton(String text, ButtonType type) {
        super(new GridLayout(1, 1));
        addButton(text, type);
        this.setBorder(BorderFactory.createLineBorder(DiscordColor.lessGray.get(), 1));
        Painter.paintBase(this);
    }

    /**
     * Add a custom themed JButton this object.
     * @param text Text the button should have.
     * @param type The type of the button, used by action listeners.
     */
    private void addButton(String text, ButtonType type) {
        JButton button = new JButton();
        button.setText(text);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.addMouseListener(new ButtonMouseAdapter(button));
        button.addActionListener(new ButtonClickAdapter(type));
        button.setPreferredSize(new Dimension(130, 30));
        button.setFocusPainted(false);
        Painter.paintBase(button);
        this.add(button);
    }
}
