package personal.opensrcerer.ui;

import personal.opensrcerer.ui.components.custom.Banner;
import personal.opensrcerer.ui.components.custom.NodeViewPort;
import personal.opensrcerer.ui.components.regular.*;
import personal.opensrcerer.ui.styling.DiscordColor;
import personal.opensrcerer.ui.styling.Fonts;

import javax.swing.*;
import java.awt.*;

public abstract class WindowLayout {

    public static final Banner banner = new Banner();

    public static void set() {
        JPanel mainPanel = new KPanel(BoxLayout.PAGE_AXIS),
                viewportWrapper = new KPanel(),
                textFieldWrapper = new KPanel(BoxLayout.LINE_AXIS, DiscordColor.darkPurple),
                leftFieldWrapper = new KPanel(BoxLayout.PAGE_AXIS, DiscordColor.darkPurple),
                rightFieldWrapper = new KPanel(BoxLayout.PAGE_AXIS, DiscordColor.darkPurple),
                inputWrapper = new KPanel(new FlowLayout(), DiscordColor.darkPurple),
                borderWrapper = new KPanel(new BorderLayout(), DiscordColor.darkPurple);

        NodeViewPort viewportPane = new NodeViewPort(30);
        viewportWrapper.add(viewportPane);

        leftFieldWrapper.add(new KLabel("Number of Suiciders", Fonts.titleFont));
        leftFieldWrapper.add(boxRigidArea(0, 5));
        leftFieldWrapper.add(new KTextField("", 5));

        rightFieldWrapper.add(new KLabel("Magic Number", Fonts.titleFont));
        rightFieldWrapper.add(boxRigidArea(0, 5));
        rightFieldWrapper.add(new KTextField("", 5));

        textFieldWrapper.add(leftFieldWrapper);
        textFieldWrapper.add(boxRigidArea(50, 0));
        textFieldWrapper.add(rightFieldWrapper);

        inputWrapper.add(textFieldWrapper);

        borderWrapper.add(new KButton("Previous"), BorderLayout.WEST);
        borderWrapper.add(inputWrapper, BorderLayout.CENTER);
        borderWrapper.add(new KButton("Next"), BorderLayout.EAST);

        mainPanel.add(banner);
        mainPanel.add(new KSeparator());
        mainPanel.add(boxRigidArea(0, 25));
        mainPanel.add(viewportPane);
        mainPanel.add(new KSeparator());
        mainPanel.add(borderWrapper);

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
