package personal.opensrcerer.ui.components.custom.messages;

import personal.opensrcerer.ui.components.regular.KLabel;
import personal.opensrcerer.ui.components.regular.KPanel;
import personal.opensrcerer.ui.styling.Fonts;

import javax.swing.*;

public class InvalidValue extends KPanel {
    private static InvalidValue invalidValue;

    private static final String TEXT = "You have entered an invalid value!";

    private InvalidValue() {
        super(BoxLayout.PAGE_AXIS);
        this.setLocation(50, 250);
        this.setSize(700, 200);
        this.add(new KLabel(TEXT, Fonts.bigTitleFont));
    }

    public static InvalidValue get() {
        if (invalidValue == null) {
            invalidValue = new InvalidValue();
        }
        return invalidValue;
    }
}
