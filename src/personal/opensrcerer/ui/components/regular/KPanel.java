package personal.opensrcerer.ui.components.regular;

import personal.opensrcerer.ui.styling.Painter;

import javax.swing.*;
import java.awt.*;

/**
 * A discord-themed JPanel.
 */
public class KPanel extends JPanel {
    public KPanel(LayoutManager manager) {
        super(manager);
    }

    public KPanel(int layout) {
        this();
        this.setLayout(new BoxLayout(this, layout));
    }

    public KPanel() {
        super();
        Painter.paintBase(this);
    }
}
