package personal.opensrcerer.ui;

import personal.opensrcerer.ui.components.custom.Banner;
import personal.opensrcerer.ui.components.custom.UINode;
import personal.opensrcerer.ui.components.stylized.KPanel;
import personal.opensrcerer.ui.components.stylized.KSeparator;

import javax.swing.*;

public class WindowLayout {
    public static void set() {
        final JPanel totalPanel = new KPanel(BoxLayout.PAGE_AXIS);

        totalPanel.add(new Banner());
        totalPanel.add(new KSeparator());
        totalPanel.add(new UINode());

        Window.getPane().add(totalPanel);
    }
}
