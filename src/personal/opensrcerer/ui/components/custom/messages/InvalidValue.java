/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

package personal.opensrcerer.ui.components.custom.messages;

import personal.opensrcerer.ui.components.regular.KLabel;
import personal.opensrcerer.ui.components.regular.KPanel;
import personal.opensrcerer.ui.styling.Fonts;

import javax.swing.*;

/**
 * A UI messaging component which pops up whenever
 * the user has inserted an invalid value.
 */
public class InvalidValue extends KPanel {

    /**
     * The singleton instance for this panel.
     */
    private static InvalidValue invalidValue;

    /**
     * Static contents of this component.
     */
    private static final String TEXT = "Oops! You have entered an invalid value!";

    /**
     * Static contents of this component.
     */
    private static final String EXPLAIN_TEXT = "Please make sure to type valid input.";

    /**
     * Private constructor to only create
     * one instance of this class.
     *
     * Sets GUI variables.
     */
    private InvalidValue() {
        super(BoxLayout.PAGE_AXIS);
        this.setLocation(50, 300);
        this.setSize(700, 200);
        this.add(new KLabel(TEXT, Fonts.bigTitleFont));
        this.add(new KLabel(EXPLAIN_TEXT, Fonts.descriptionFont));
    }

    /**
     * @return The singleton instance of this component.
     */
    public static InvalidValue get() {
        if (invalidValue == null) {
            invalidValue = new InvalidValue();
        }
        return invalidValue;
    }
}
