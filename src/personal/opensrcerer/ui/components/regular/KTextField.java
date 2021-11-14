package personal.opensrcerer.ui.components.regular;

import personal.opensrcerer.ui.components.events.FieldKeyAdapter;
import personal.opensrcerer.ui.components.events.FieldMouseAdapter;
import personal.opensrcerer.ui.styling.DiscordColor;
import personal.opensrcerer.ui.styling.Fonts;
import personal.opensrcerer.ui.styling.Painter;

import javax.swing.*;
import java.awt.*;

/**
 * A custom JTextField.
 */
public class KTextField extends JTextField {

    /**
     * @param defaultText Default placeholder text for JTextField.
     * @param columns Number of columns JTextField will be constructed with.
     */
    public KTextField(String defaultText, int columns) {
        super(defaultText, columns);
        Painter.paintBase(this);
        this.setMaximumSize(new Dimension(100, 50));
        this.setFont(Fonts.actionFont.get());
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setCaretColor(DiscordColor.lightGray.get());
        this.addKeyListener(new FieldKeyAdapter(this));
        this.addMouseListener(new FieldMouseAdapter(this));
    }
}
