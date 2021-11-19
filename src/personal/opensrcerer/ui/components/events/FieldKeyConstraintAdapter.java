package personal.opensrcerer.ui.components.events;

import personal.opensrcerer.ui.UIConstants;
import personal.opensrcerer.ui.components.regular.KTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FieldKeyConstraintAdapter extends KeyAdapter {

    private final KTextField field;

    public FieldKeyConstraintAdapter(KTextField field) {
        this.field = field;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (field.type) {
            case SUICIDERS -> {
                if (field.getText().length() + 1 > UIConstants.SUICIDER_NUMBER_FIELD_CHARACTER_LIMIT) {
                    e.consume();
                }
            }
            case MAGIC_NUMBER -> {
                if (field.getText().length() + 1 > UIConstants.MAGIC_NUMBER_FIELD_CHARACTER_LIMIT) {
                    e.consume();
                }
            }
        }
    }
}
