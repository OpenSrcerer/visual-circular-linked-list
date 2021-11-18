package personal.opensrcerer.ui.components.custom;

import personal.opensrcerer.entities.Suicider;
import personal.opensrcerer.entities.SuiciderManager;
import personal.opensrcerer.ui.WindowLayout;
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

    public void setNodes() {
        this.removeAll();

        int nodes = SuiciderManager.getSuiciderNodes();
        int magicNumber = SuiciderManager.getMagicNumber();

        if (magicNumber < 1 || (nodes < 2 || nodes > 40)) {
            this.add(InvalidValue.get());
            this.refresh();
            return;
        }

        SuiciderManager manager = SuiciderManager.getInstance();
        manager.clear();
        Suicider[] suiciders = manager.getListOfNodes();

        SuiciderNode[] nodesList = getNodesInCircle(
                suiciders,
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

        WindowLayout.banner.update();
        this.refresh();
    }

    public SuiciderNode[] getNodesInCircle(
            Suicider[] suiciders,
            double circleRadius,
            int biasX,
            int biasY
    ) {
        SuiciderNode[] nodesList = new SuiciderNode[suiciders.length];
        double theta = 360d / suiciders.length;

        for (int index = 0; index < suiciders.length; ++index) {
            double thetaRadians = Math.toRadians(theta * index);
            int x = (int) (circleRadius * Math.cos(thetaRadians));
            int y = (int) (circleRadius * Math.sin(thetaRadians));

            nodesList[index] = new SuiciderNode(
                    biasX + x,
                    biasY + y,
                    suiciders[index]
            );
            if (!nodesList[index].isKitsos()) {
                nodesList[index].kill();
            }
        }
        return nodesList;
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
