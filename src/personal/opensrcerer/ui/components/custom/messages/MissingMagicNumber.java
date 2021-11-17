package personal.opensrcerer.ui.components.custom.messages;

import personal.opensrcerer.ui.components.regular.KLabel;
import personal.opensrcerer.ui.components.regular.KPanel;
import personal.opensrcerer.ui.styling.Fonts;

import javax.swing.*;

public class MissingMagicNumber extends KPanel {
    private static MissingMagicNumber missingMagicNumber;

    private static final String TEXT = "Missing Magic Number";

    public MissingMagicNumber() {
        super(BoxLayout.PAGE_AXIS);
        this.setLocation(50, 250);
        this.setSize(700, 200);
        this.add(new KLabel(TEXT, Fonts.bigTitleFont));
    }

    public static MissingMagicNumber get() {
        if (missingMagicNumber == null) {
            missingMagicNumber = new MissingMagicNumber();
        }
        return missingMagicNumber;
    }
}
