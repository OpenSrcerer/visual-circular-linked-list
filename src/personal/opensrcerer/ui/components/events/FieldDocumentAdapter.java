package personal.opensrcerer.ui.components.events;

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
            return;
        }

        int value;
        try {
            value = Integer.parseInt(this.field.getText());
            if (value < 2) {
                throw new NumberFormatException();
            }

            if (value > 50) {
                throw new NumberFormatException();
            }
        } catch (Exception ex) {
            value = 1;
        }

        if (this.field.type.equals(FieldType.SUICIDERS)) {
            WindowLayout.viewportPane.setNodes(value);
        }
        System.out.println(field.getText());
    }
}
