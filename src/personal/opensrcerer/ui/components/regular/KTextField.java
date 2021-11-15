package personal.opensrcerer.ui.components.regular;

import personal.opensrcerer.ui.components.events.FieldKeyConstraintAdapter;
import personal.opensrcerer.ui.components.events.FieldMouseAdapter;
import personal.opensrcerer.ui.components.events.FieldNumberUpdateAdapter;
import personal.opensrcerer.ui.components.events.FieldType;
import personal.opensrcerer.ui.styling.DiscordColor;
import personal.opensrcerer.ui.styling.Fonts;
import personal.opensrcerer.ui.styling.Painter;

import javax.swing.*;
import java.awt.*;

/**
 * A custom JTextField.
 */
public class KTextField extends JTextField {

    public final FieldType type;

    /**
     * @param defaultText Default placeholder text for JTextField.
     * @param columns Number of columns JTextField will be constructed with.
     */
    public KTextField(String defaultText, int columns, FieldType type) {
        super(defaultText, columns);
        Painter.paintBase(this);
        this.type = type;
        this.setMaximumSize(new Dimension(100, 50));
        this.setFont(Fonts.actionFont.get());
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setCaretColor(DiscordColor.lightGray.get());
        this.addKeyListener(new FieldKeyConstraintAdapter(this));
        this.addKeyListener(new FieldNumberUpdateAdapter(this));
        this.addMouseListener(new FieldMouseAdapter(this));
    }
}
