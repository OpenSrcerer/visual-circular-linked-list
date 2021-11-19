package personal.opensrcerer.ui.components.events;

import personal.opensrcerer.entities.SuicideManager;
import personal.opensrcerer.ui.WindowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickAdapter implements ActionListener {

    private final ButtonType type;

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
