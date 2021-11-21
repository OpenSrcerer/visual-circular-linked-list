/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

package personal.opensrcerer.ui.components.events;

import personal.opensrcerer.entities.SuicideManager;
import personal.opensrcerer.ui.WindowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * An action listener that performs actions when a button is clicked.
 */
public class ButtonClickAdapter implements ActionListener {

    /**
     * The Button Type related to this action listener.
     */
    private final ButtonType type;

    /**
     * Create a new ButtonClickAdapter.
     * @param type The button type related to this listener.
     */
    public ButtonClickAdapter(ButtonType type) {
        this.type = type;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (SuicideManager.getInstance().size() == 0) {
            return;
        }

        switch (type) {
            case FIRST -> WindowLayout.viewportPane.first();
            case PREVIOUS -> WindowLayout.viewportPane.previousStep();
            case NEXT -> WindowLayout.viewportPane.nextStep();
            case LAST -> WindowLayout.viewportPane.last();
        }
    }
}
