package personal.opensrcerer.ui.components.custom.messages;

import personal.opensrcerer.ui.components.regular.KLabel;
import personal.opensrcerer.ui.components.regular.KPanel;
import personal.opensrcerer.ui.styling.Fonts;

import javax.swing.*;

public class MissingSuiciderNumber extends KPanel {
    private static MissingSuiciderNumber missingSuiciderNumber;

    private static final String TEXT = "Missing Suicider Number";

    public MissingSuiciderNumber() {
        super(BoxLayout.PAGE_AXIS);
        this.setLocation(50, 250);
        this.setSize(700, 200);
        this.add(new KLabel(TEXT, Fonts.bigTitleFont));
    }

    public static MissingSuiciderNumber get() {
        if (missingSuiciderNumber == null) {
            missingSuiciderNumber = new MissingSuiciderNumber();
        }
        return missingSuiciderNumber;
    }
}
