package personal.opensrcerer.ui.components.custom.messages;

import personal.opensrcerer.ui.components.regular.KLabel;
import personal.opensrcerer.ui.components.regular.KPanel;
import personal.opensrcerer.ui.styling.Fonts;

import javax.swing.*;

public class MissingSuiciderNumber extends KPanel {
    private static MissingSuiciderNumber missingSuiciderNumber;

    private static final String TITLE_TEXT = "Please insert a suicider number value!";

    private static final String EXPLAIN_TEXT = "You may insert a number from 1 - 40.";

    public MissingSuiciderNumber() {
        super(BoxLayout.PAGE_AXIS);
        this.setLocation(50, 300);
        this.setSize(700, 200);
        this.add(new KLabel(TITLE_TEXT, Fonts.bigTitleFont));
        this.add(new KLabel(EXPLAIN_TEXT, Fonts.descriptionFont));
    }

    public static MissingSuiciderNumber get() {
        if (missingSuiciderNumber == null) {
            missingSuiciderNumber = new MissingSuiciderNumber();
        }
        return missingSuiciderNumber;
    }
}
