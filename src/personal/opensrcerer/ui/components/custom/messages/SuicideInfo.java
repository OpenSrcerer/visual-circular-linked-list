/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

package personal.opensrcerer.ui.components.custom.messages;

import personal.opensrcerer.entities.SuicideManager;
import personal.opensrcerer.ui.WindowLayout;
import personal.opensrcerer.ui.components.regular.KLabel;
import personal.opensrcerer.ui.components.regular.KPanel;
import personal.opensrcerer.ui.styling.Fonts;

import javax.swing.*;

/**
 * A UI messaging component which pops up whenever
 * the user has inserted an invalid value.
 */
public class SuicideInfo extends KPanel {

    /**
     * The singleton instance for this panel.
     */
    private static SuicideInfo suicideInfo;

    /**
     * Static contents of this component.
     */
    private static final KLabel lastSuicideLabel = new KLabel("Last Suicide: ", Fonts.descriptionFont);

    /**
     * Static contents of this component.
     */
    private static final KLabel lastSuicidePosition = new KLabel("Last Suicide Position: ", Fonts.descriptionFont);

    /**
     * Private constructor to only create
     * one instance of this class.
     *
     * Sets GUI variables.
     */
    private SuicideInfo() {
        super(BoxLayout.PAGE_AXIS);
        this.setLocation(50, 290);
        this.setSize(700, 200);
        this.add(lastSuicideLabel);
        this.add(lastSuicidePosition);
    }

    /**
     * @return The singleton instance of this component.
     */
    public static SuicideInfo get(int nodes) {
        if (suicideInfo == null) {
            suicideInfo = new SuicideInfo();
        }

        switch (nodes) {
            case 2 -> suicideInfo.setLocation(50, 200);
            case 3 -> suicideInfo.setLocation(90, 290);
            default -> suicideInfo.setLocation(50, 290);
        }

        update();
        return suicideInfo;
    }

    /**
     * Update this component to display last suicide information.
     */
    public static void update() {
        lastSuicideLabel.setText("Last Suicide: " +
                WindowLayout.viewportPane.getSuiciderNameByPosition(SuicideManager.getSnapshot()));
        lastSuicidePosition.setText("Last Suicide Position: " + SuicideManager.getSnapshot());
        refresh();
    }

    /**
     * Update this component to display text
     * that no suicides have been committed yet.
     */
    public static void noSuicides() {
        lastSuicideLabel.setText("No Suicides yet!");
        lastSuicidePosition.setText("");
        refresh();
    }

    /**
     * Refresh this component by invalidating and repainting it.
     * Also refresh the viewportPane.
     */
    private static void refresh() {
        suicideInfo.invalidate();
        suicideInfo.repaint();
        WindowLayout.viewportPane.refresh();
    }
}
