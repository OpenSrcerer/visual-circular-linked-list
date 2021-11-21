/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

package personal.opensrcerer.ui.components.events;

import personal.opensrcerer.ui.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * An action listener that performs actions when an event
 * occurs in a JTextField.
 * Used to update cursors when entering text fields.
 */
public class FieldMouseAdapter extends MouseAdapter {

    /**
     * The JTextField to keep reference to.
     */
    private final JTextField field;

    /**
     * Create a new FieldMouseAdapter.
     * @param field The JTextField to reference.
     */
    public FieldMouseAdapter(JTextField field) {
        this.field = field;
    }

    @Override
    public void mouseEntered(MouseEvent evt) {
        Window.contentPane().setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent evt) {
        Window.contentPane().setCursor(Cursor.getDefaultCursor());
    }
}
