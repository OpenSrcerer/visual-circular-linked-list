/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

package personal.opensrcerer.ui.components.events;

import personal.opensrcerer.ui.UIConstants;
import personal.opensrcerer.ui.components.regular.KTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * An Event Listener that constraints KTextFields
 * to contain a specific number of characters.
 */
public class FieldKeyConstraintAdapter extends KeyAdapter {

    /**
     * The KTextField that this Event Listener relates to.
     */
    private final KTextField field;

    /**
     * Create a new FieldKeyConstraintAdapter.
     * @param field The KTextField this adapter references.
     */
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
