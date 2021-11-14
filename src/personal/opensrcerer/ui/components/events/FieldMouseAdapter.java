package personal.opensrcerer.ui.components.events;

import personal.opensrcerer.ui.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FieldMouseAdapter extends MouseAdapter {

    private final JTextField field;

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
