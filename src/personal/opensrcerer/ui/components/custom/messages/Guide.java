package personal.opensrcerer.ui.components.custom.messages;

import personal.opensrcerer.ui.WindowLayout;
import personal.opensrcerer.ui.components.regular.KLabel;
import personal.opensrcerer.ui.components.regular.KPanel;
import personal.opensrcerer.ui.styling.Fonts;

import javax.swing.*;
import java.awt.*;

public class Guide extends KPanel {
    private static Guide guide;

    private static final String TEXT = "Welcome to Kitsos' Program!";

    private static final String EXPLAIN_TEXT_1 = "Please insert the values below to begin.";

    private static final String EXPLAIN_TEXT_2 = "You may also use the buttons to shift between steps:";

    private static final String EXPLAIN_TEXT_3 = "<html><li><b>First</b> - Go to the state before any suicides</li></html>";

    private static final String EXPLAIN_TEXT_4 = "<html><li><b>Previous</b> - View the previous suicide</li></html>";

    private static final String EXPLAIN_TEXT_5 = "<html><li><b>Next</b> - View the next suicide</li></html>";

    private static final String EXPLAIN_TEXT_6 = "<html><li><b>Last</b> - Go to the state after the last suicide</li></html>";

    private Guide() {
        super(BoxLayout.PAGE_AXIS);
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setLocation(50, 150);
        this.setSize(700, 400);
        this.addText();
    }

    private void addText() {
        this.add(new KLabel(TEXT, Fonts.bigTitleFont));
        this.add(WindowLayout.boxRigidArea(0, 20));
        this.add(new KLabel(EXPLAIN_TEXT_1, Fonts.descriptionFont));
        this.add(new KLabel(EXPLAIN_TEXT_2, Fonts.descriptionFont));
        this.add(WindowLayout.boxRigidArea(0, 20));
        this.add(new KLabel(EXPLAIN_TEXT_3, Fonts.descriptionFont));
        this.add(new KLabel(EXPLAIN_TEXT_4, Fonts.descriptionFont));
        this.add(new KLabel(EXPLAIN_TEXT_5, Fonts.descriptionFont));
        this.add(new KLabel(EXPLAIN_TEXT_6, Fonts.descriptionFont));
    }

    public static Guide get() {
        if (guide == null) {
            guide = new Guide();
        }
        return guide;
    }
}
