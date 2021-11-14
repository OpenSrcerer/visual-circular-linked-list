package personal.opensrcerer.ui.components.regular;

import personal.opensrcerer.ui.components.events.ButtonMouseAdapter;
import personal.opensrcerer.ui.styling.Painter;

import javax.swing.*;
import java.awt.*;

/**
 * A discord-themed JButton.
 */
public class KButton extends JButton {

    /**
     * Retrieves a custom JButton.
     * @param text Name and initial text of button.
     */
    public KButton(String text) {
        super(text);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.addMouseListener(new ButtonMouseAdapter(this));
        this.setPreferredSize(new Dimension(130, 70));
        Painter.paintBase(this);
    }
}
