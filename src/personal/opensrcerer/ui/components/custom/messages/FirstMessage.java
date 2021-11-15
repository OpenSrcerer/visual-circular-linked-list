package personal.opensrcerer.ui.components.custom.messages;

import personal.opensrcerer.ui.components.regular.KLabel;
import personal.opensrcerer.ui.components.regular.KPanel;
import personal.opensrcerer.ui.styling.Fonts;

import javax.swing.*;
import java.awt.*;

public class FirstMessage extends KPanel {
    public static FirstMessage firstMessage;

    private static final String GUIDE_TEXT = "GUIDE LOL";

    private FirstMessage() {
        super(BoxLayout.PAGE_AXIS);

        KLabel kLabel = new KLabel(GUIDE_TEXT, Fonts.bigTitleFont);

        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setLocation(50, 250);
        this.setSize(700, 200);
        this.add(kLabel);
    }

    public static FirstMessage get() {
        if (firstMessage == null) {
            firstMessage = new FirstMessage();
        }
        return firstMessage;
    }
}
