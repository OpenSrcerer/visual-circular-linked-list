package personal.opensrcerer.ui.components.events;

import personal.opensrcerer.ui.Window;
import personal.opensrcerer.ui.WindowLayout;
import personal.opensrcerer.ui.components.custom.SuiciderNode;
import personal.opensrcerer.ui.styling.DiscordColor;

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
        WindowLayout.banner.update("Selected: " + node.name() +
                (node.isDead() ? " (Dead)" : "") + " // " + "Position: " + node.position());
        node.setHover(true);
        node.refresh();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Window.contentPane().setCursor(Cursor.getDefaultCursor());
        WindowLayout.banner.update();
        node.setHover(false);
        node.refresh();
    }
}
