/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

package personal.opensrcerer.ui.components.events;

import personal.opensrcerer.ui.Window;
import personal.opensrcerer.ui.WindowLayout;
import personal.opensrcerer.ui.components.custom.SuiciderNode;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A Mouse event listener that is used to update the information on
 * SuiciderNodes upon hovering on the node.
 */
public class NodeMouseAdapter extends MouseAdapter {

    /**
     * The SuiciderNode to keep as a reference.
     */
    private final SuiciderNode node;

    /**
     * Create a new NodeMouseAdapter.
     * @param node The Node that relates to this adapter.
     */
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
