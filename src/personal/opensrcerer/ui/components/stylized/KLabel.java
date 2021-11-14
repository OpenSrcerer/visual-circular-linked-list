package personal.opensrcerer.ui.components.stylized;

import personal.opensrcerer.ui.styling.Painter;
import personal.opensrcerer.ui.styling.Fonts;

import javax.swing.*;
import java.awt.*;

/**
 * A discord-themed JLabel.
 */
public class KLabel extends JLabel {

    public KLabel(String name, Fonts font) {
        super(name);
        Painter.paintBase(this);
        this.setFont(font.get());
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
}
