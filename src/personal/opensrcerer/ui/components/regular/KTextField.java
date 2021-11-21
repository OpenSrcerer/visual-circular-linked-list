/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

package personal.opensrcerer.ui.components.regular;

import personal.opensrcerer.ui.components.events.FieldDocumentAdapter;
import personal.opensrcerer.ui.components.events.FieldKeyConstraintAdapter;
import personal.opensrcerer.ui.components.events.FieldMouseAdapter;
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

    /**
     * The field type of this text field.
     * Used by action listeners to identify which action to take.
     */
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
        this.setFont(Fonts.textFieldFont.get());
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setCaretColor(DiscordColor.lightGray.get());
        this.addKeyListener(new FieldKeyConstraintAdapter(this));
        this.getDocument().addDocumentListener(new FieldDocumentAdapter(this));
        this.addMouseListener(new FieldMouseAdapter(this));
    }
}
