package personal.opensrcerer.ui.components.events;

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
        switch (type) {
            case NEXT -> WindowLayout.viewportPane.previousStep();
            case PREVIOUS -> WindowLayout.viewportPane.nextStep();
            case SNAPSHOT -> {}
        }
    }
}
