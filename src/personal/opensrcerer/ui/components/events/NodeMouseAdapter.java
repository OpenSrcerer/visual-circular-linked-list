package personal.opensrcerer.ui.components.events;

import personal.opensrcerer.ui.Window;
import personal.opensrcerer.ui.components.custom.SuiciderNode;
import personal.opensrcerer.ui.styling.Colors;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NodeMouseAdapter extends MouseAdapter {
    private final SuiciderNode node;

    public NodeMouseAdapter(SuiciderNode node) {
        this.node = node;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Window.contentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        node.setColor(Colors.discordPurple);
        node.invalidate();
        node.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Window.contentPane().setCursor(Cursor.getDefaultCursor());
        node.setColor((node.isKitsos()) ? Colors.discordIdle : Colors.discordBlurple);
        node.invalidate();
        node.repaint();
    }
}
