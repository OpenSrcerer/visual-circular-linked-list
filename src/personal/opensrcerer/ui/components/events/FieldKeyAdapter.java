package personal.opensrcerer.ui.components.events;

import personal.opensrcerer.ui.UIConstants;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FieldKeyAdapter extends KeyAdapter {

    private final JTextField field;

    public FieldKeyAdapter(JTextField field) {
        this.field = field;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (field.getText().length() >= UIConstants.FIELD_CHARACTER_LIMIT) {
            e.consume();
        }
    }
}
