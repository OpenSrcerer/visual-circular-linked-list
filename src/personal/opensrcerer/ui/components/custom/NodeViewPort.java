package personal.opensrcerer.ui.components.custom;

import personal.opensrcerer.ui.components.custom.arrows.ArrowLine;
import personal.opensrcerer.ui.styling.Painter;

import javax.swing.*;
import java.awt.*;

/**
 * A custom pane that is designated to display the nodes in a
 * circular fashion.
 */
public class NodeViewPort extends JLayeredPane {
    public NodeViewPort(int nodes) {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1000,700));
        Painter.paintBase(this);

        SuiciderNode[] nodesList = getNodesInCircle(
                nodes,
                300,
                480,
                330
        );

        SuiciderNode previous = nodesList[nodes - 1];
        for (SuiciderNode node : nodesList) {
            this.add(node);
            this.add(new ArrowLine(previous, node), 1);
            previous = node;
        }
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
                    biasY + y
            );
        }
        return nodesList;
    }
}
