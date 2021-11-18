package personal.opensrcerer.ui.components.events;

import personal.opensrcerer.entities.SuiciderManager;
import personal.opensrcerer.ui.WindowLayout;
import personal.opensrcerer.ui.components.regular.KTextField;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class FieldDocumentAdapter implements DocumentListener {

    private final KTextField field;

    public FieldDocumentAdapter(KTextField field) {
        this.field = field;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        this.updateNodes();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        this.updateNodes();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        this.updateNodes();
    }

    private void updateNodes() {
        if (this.field.getText().isBlank()) {
            WindowLayout.viewportPane.reset();

            if (this.field.type.equals(FieldType.SUICIDERS)) {
                SuiciderManager.setValues(null, SuiciderManager.getMagicNumber());
            } else {
                SuiciderManager.setValues(SuiciderManager.getSuiciderNodes(), null);
            }
            return;
        }

        int value;
        try {
            value = Integer.parseInt(this.field.getText());
            if (value < 1 || value < 2 && this.field.type.equals(FieldType.SUICIDERS)) {
                throw new NumberFormatException();
            }
            if (value > 40 && this.field.type.equals(FieldType.SUICIDERS)) {
                throw new NumberFormatException();
            }
        } catch (Exception ex) {
            value = 0;
        }

        if (this.field.type.equals(FieldType.SUICIDERS)) {
            SuiciderManager.setValues(value, SuiciderManager.getMagicNumber());
        } else {
            SuiciderManager.setValues(SuiciderManager.getSuiciderNodes(), value);
        }
    }
}
