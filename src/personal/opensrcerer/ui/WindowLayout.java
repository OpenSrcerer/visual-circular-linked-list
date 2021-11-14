package personal.opensrcerer.ui;

import personal.opensrcerer.ui.components.custom.Banner;
import personal.opensrcerer.ui.components.custom.NodeViewPort;
import personal.opensrcerer.ui.components.regular.KPanel;
import personal.opensrcerer.ui.components.regular.KSeparator;
import personal.opensrcerer.ui.components.regular.KTextField;
import personal.opensrcerer.ui.styling.DiscordColor;

import javax.swing.*;
import java.awt.*;

public abstract class WindowLayout {
    public static void set() {
        JPanel mainPanel = new KPanel(BoxLayout.PAGE_AXIS),
                viewportWrapper = new KPanel(),
                textFieldWrapper = new KPanel(new FlowLayout(), DiscordColor.pastelPurple);

        mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        NodeViewPort viewportPane = new NodeViewPort(30);
        viewportWrapper.add(viewportPane);

        textFieldWrapper.add(new KTextField("", 10));
        textFieldWrapper.add(new KTextField("", 10));

        mainPanel.add(new Banner());
        mainPanel.add(new KSeparator());
        mainPanel.add(boxRigidArea(0, 25));
        mainPanel.add(viewportPane);
        mainPanel.add(new KSeparator());
        mainPanel.add(textFieldWrapper);

        Window.contentPane().add(mainPanel);
    }

    /**
     * Utility method that creates a rigid area with x and y values.
     * Used as syntactic sugar.
     * @param x X value of the rigid area.
     * @param y Y value of the rigid area.
     * @return Newly created rigid area with the size X, Y.
     */
    private static Component boxRigidArea(int x, int y) {
        return Box.createRigidArea(new Dimension(x, y));
    }
}
