/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

package personal.opensrcerer.ui.components.events;

import personal.opensrcerer.ui.Window;
import personal.opensrcerer.ui.styling.DiscordColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A Mouse Event Listener adapter that performs action
 * when a mouse action is performed.
 */
public class ButtonMouseAdapter extends MouseAdapter {

    /**
     * This JButton associated with this Mouse Event Listener.
     */
    private final JButton button;

    /**
     * Create a new ButtonMouseAdapter.
     * @param button The JButton associated with this listener.
     */
    public ButtonMouseAdapter(JButton button) {
        this.button = button;
    }

    @Override
    public void mouseEntered(MouseEvent evt) {
        Window.contentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBackground(DiscordColor.lessGray.get());
    }

    @Override
    public void mouseExited(MouseEvent evt) {
        Window.contentPane().setCursor(Cursor.getDefaultCursor());
        button.setBackground(DiscordColor.regularGray.get());
    }

    @Override
    public void mousePressed(MouseEvent evt) {
        button.setBackground(DiscordColor.regularGray.get());
    }
}
