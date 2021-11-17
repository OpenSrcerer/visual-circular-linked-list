package personal.opensrcerer.ui.components.custom;

import personal.opensrcerer.ui.components.custom.messages.FirstMessage;
import personal.opensrcerer.ui.components.custom.messages.InvalidValue;
import personal.opensrcerer.ui.components.custom.messages.MissingMagicNumber;
import personal.opensrcerer.ui.components.custom.messages.MissingSuiciderNumber;
import personal.opensrcerer.ui.styling.Painter;
import personal.opensrcerer.util.NameGenerator;

import javax.swing.*;
import java.awt.*;

/**
 * A custom pane that is designated to display the nodes in a
 * circular fashion.
 */
public class NodeViewPort extends JLayeredPane {

    public NodeViewPort() {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(800,700));
        Painter.paintBase(this);
        add(FirstMessage.get());
    }

    public SuiciderNode[] getNodesInCircle(
            int nodes,
            double circleRadius,
            int biasX,
            int biasY
    ) {
        SuiciderNode[] nodesList = new SuiciderNode[nodes];
        double theta = 360d / nodes;

        for (int index = 0; index < nodes; ++index) {
            double thetaRadians = Math.toRadians(theta * index);
            int x = (int) (circleRadius * Math.cos(thetaRadians));
            int y = (int) (circleRadius * Math.sin(thetaRadians));

            nodesList[index] = new SuiciderNode(
                    biasX + x,
                    biasY + y,
                    NameGenerator.getRandomName()
            );
        }
        return nodesList;
    }

    public void setNodes(int nodes) {
        this.removeAll();

        if (nodes < 2 || nodes > 50) {
            this.add(InvalidValue.get());
            this.refresh();
            return;
        }

        SuiciderNode[] nodesList = getNodesInCircle(
                nodes,
                300,
                375,
                300
        );

        SuiciderNode previous = nodesList[nodes - 1];
        for (SuiciderNode node : nodesList) {
            this.add(node, 0);
            this.add(new Line(previous, node), -1);
            previous = node;
        }

        this.refresh();
    }

    public void setMissingMagicNumber() {
        this.removeAll();
        this.add(MissingMagicNumber.get());
        this.refresh();
    }

    public void setMissingSuiciderNumber() {
        this.removeAll();
        this.add(MissingSuiciderNumber.get());
        this.refresh();
    }

    public void reset() {
        this.removeAll();
        this.add(FirstMessage.get());
        this.refresh();
    }

    private void refresh() {
        this.invalidate();
        this.repaint();
    }
}
