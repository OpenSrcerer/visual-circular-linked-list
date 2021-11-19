package personal.opensrcerer.ui.components.custom.messages;

import personal.opensrcerer.entities.SuicideManager;
import personal.opensrcerer.ui.WindowLayout;
import personal.opensrcerer.ui.components.regular.KLabel;
import personal.opensrcerer.ui.components.regular.KPanel;
import personal.opensrcerer.ui.styling.Fonts;

import javax.swing.*;

public class SuicideInfo extends KPanel {
    private static SuicideInfo suicideInfo;

    private static final KLabel lastSuicideLabel = new KLabel("Last Suicide: ", Fonts.descriptionFont);

    private static final KLabel lastSuicidePosition = new KLabel("Last Suicide Position: ", Fonts.descriptionFont);

    public SuicideInfo() {
        super(BoxLayout.PAGE_AXIS);
        this.setLocation(50, 290);
        this.setSize(700, 200);
        this.add(lastSuicideLabel);
        this.add(lastSuicidePosition);
    }

    public static SuicideInfo get(int nodes) {
        if (suicideInfo == null) {
            suicideInfo = new SuicideInfo();
        }

        switch (nodes) {
            case 2 -> suicideInfo.setLocation(50, 200);
            case 3 -> suicideInfo.setLocation(70, 290);
            default -> suicideInfo.setLocation(50, 290);
        }

        update();
        return suicideInfo;
    }

    public static void update() {
        lastSuicideLabel.setText("Last Suicide: " +
                WindowLayout.viewportPane.getSuiciderNameByPosition(SuicideManager.getSnapshot()));
        lastSuicidePosition.setText("Last Suicide Position: " + SuicideManager.getSnapshot());
        refresh();
    }

    public static void noSuicides() {
        lastSuicideLabel.setText("No Suicides yet!");
        lastSuicidePosition.setText("");
        refresh();
    }

    private static void refresh() {
        suicideInfo.invalidate();
        suicideInfo.repaint();
        WindowLayout.viewportPane.refresh();
    }
}
