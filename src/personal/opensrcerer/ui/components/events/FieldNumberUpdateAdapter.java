package personal.opensrcerer.ui.components.events;

import personal.opensrcerer.ui.WindowLayout;
import personal.opensrcerer.ui.components.regular.KTextField;

import java.awt.event.KeyEvent;

public class FieldNumberUpdateAdapter extends FieldKeyConstraintAdapter {
    public FieldNumberUpdateAdapter(KTextField field) {
        super(field);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10 || e.getKeyCode() == 13) { // enter
            int value;
            try {
                value = Integer.parseInt(super.field.getText());
            } catch (Exception ex) {
                return;
            }

            if (super.field.type.equals(FieldType.SUICIDERS)) {
                WindowLayout.viewportPane.setNodes(value);
            }
        }
    }
}
