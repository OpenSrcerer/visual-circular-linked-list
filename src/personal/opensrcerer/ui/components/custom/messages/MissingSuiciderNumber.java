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
 * the user has not inserted a value for the magic number.
 */
public class MissingSuiciderNumber extends KPanel {

    /**
     * The singleton instance for this panel.
     */
    private static MissingSuiciderNumber missingSuiciderNumber;

    /**
     * Static contents of this component.
     */
    private static final String TITLE_TEXT = "Please insert a suicider number value!";

    /**
     * Static contents of this component.
     */
    private static final String EXPLAIN_TEXT = "You may insert a number from 1 - 40.";

    /**
     * Private constructor to only create
     * one instance of this class.
     *
     * Sets GUI variables.
     */
    private MissingSuiciderNumber() {
        super(BoxLayout.PAGE_AXIS);
        this.setLocation(50, 300);
        this.setSize(700, 200);
        this.add(new KLabel(TITLE_TEXT, Fonts.bigTitleFont));
        this.add(new KLabel(EXPLAIN_TEXT, Fonts.descriptionFont));
    }

    /**
     * @return The singleton instance of this component.
     */
    public static MissingSuiciderNumber get() {
        if (missingSuiciderNumber == null) {
            missingSuiciderNumber = new MissingSuiciderNumber();
        }
        return missingSuiciderNumber;
    }
}
