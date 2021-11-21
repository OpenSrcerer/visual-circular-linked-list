/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

package personal.opensrcerer.ui.components.events;

import personal.opensrcerer.entities.SuicideManager;
import personal.opensrcerer.ui.WindowLayout;
import personal.opensrcerer.ui.components.regular.KTextField;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * A Document Event Listener that handles events when the Document
 * of a KTextField changes.
 */
public class FieldDocumentAdapter implements DocumentListener {

    /**
     * The KTextField whose document to monitor for changes.
     */
    private final KTextField field;

    /**
     * Create a new FieldDocumentAdapter for the given KTextField.
     * @param field The KTextField this Adapter is associated with.
     */
    public FieldDocumentAdapter(KTextField field) {
        this.field = field;
    }

    /**
     * Update the nodes of the NodeViewPort to a new value.
     */
    private void updateNodes() {
        if (this.field.getText().isBlank()) {
            WindowLayout.viewportPane.reset();

            if (this.field.type.equals(FieldType.SUICIDERS)) {
                SuicideManager.setValues(null, SuicideManager.getMagicNumber());
            } else {
                SuicideManager.setValues(SuicideManager.getSuiciderNodes(), null);
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
            SuicideManager.setValues(value, SuicideManager.getMagicNumber());
        } else {
            SuicideManager.setValues(SuicideManager.getSuiciderNodes(), value);
        }
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
}
