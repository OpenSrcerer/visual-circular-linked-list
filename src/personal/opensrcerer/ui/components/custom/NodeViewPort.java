package personal.opensrcerer.ui.components.custom;

import personal.opensrcerer.entities.Suicider;
import personal.opensrcerer.entities.SuicideManager;
import personal.opensrcerer.ui.UIConstants;
import personal.opensrcerer.ui.WindowLayout;
import personal.opensrcerer.ui.components.custom.messages.*;
import personal.opensrcerer.ui.styling.Painter;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * A custom pane that is designated to display the nodes in a
 * circular fashion.
 */
public class NodeViewPort extends JLayeredPane {

    private final Map<Integer, SuiciderNode> suiciderMap = new HashMap<>();

    public NodeViewPort() {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(800,700));
        Painter.paintBase(this);
        add(FirstMessage.get());
    }

    public void setNodes() {
        this.removeAll();

        int nodes = SuicideManager.getSuiciderNodes();
        int magicNumber = SuicideManager.getMagicNumber();

        if (magicNumber < 1 || (nodes < 2 || nodes > 40)) {
            this.add(InvalidValue.get());
            this.refresh();
            return;
        }

        SuicideManager manager = SuicideManager.getInstance();
        manager.clear();
        this.suiciderMap.clear();

        Suicider[] suiciders = manager.getListOfNodes();
        SuiciderNode[] nodesList = getNodesInCircle(suiciders);

        SuiciderNode previous = nodesList[nodes - 1];
        for (SuiciderNode node : nodesList) {
            this.suiciderMap.put(node.position(), node);
            this.add(node, 0);
            this.add(new Line(previous, node), -1);
            previous = node;
        }

        this.add(SuicideInfo.get(nodes));
        WindowLayout.banner.update();
        this.refresh();
    }

    public void first() {
        this.suiciderMap.forEach((pos, node) -> node.revive());
        SuicideManager.setCurrentStep(-1);
        SuicideInfo.noSuicides();
    }

    public void previousStep() {
        int nodeToRevivePosition = SuicideManager.getSnapshot();
        SuiciderNode node = suiciderMap.get(nodeToRevivePosition);
        node.revive();
        SuicideManager.setCurrentStep(
                SuicideManager.getCurrentStep() - (
                (SuicideManager.getCurrentStep() == 0) ? 2 : 1));
        if (SuicideManager.getCurrentStep() == -1) {
            SuicideInfo.noSuicides();
        } else {
            SuicideInfo.update();
        }
    }

    public void nextStep() {
        SuicideManager.setCurrentStep(SuicideManager.getCurrentStep() + 1);
        int nodeToKillPosition = SuicideManager.getSnapshot();
        SuiciderNode node = suiciderMap.get(nodeToKillPosition);
        node.kill();
        SuicideInfo.update();
    }

    public void last() {
        this.suiciderMap.forEach((pos, node) -> {
            if (!node.isKitsos()) {
                node.kill();
            }
        });
        SuicideManager.setCurrentStep(Integer.MAX_VALUE);
        SuicideInfo.update();
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

    public void refresh() {
        this.invalidate();
        this.repaint();
    }

    public String getSuiciderNameByPosition(int pos) {
        SuiciderNode node = suiciderMap.get(pos);
        if (node == null) {
            return "";
        }
        return node.name();
    }

    private SuiciderNode[] getNodesInCircle(Suicider[] suiciders) {
        SuiciderNode[] nodesList = new SuiciderNode[suiciders.length];
        double theta = 360d / suiciders.length;

        for (int index = 0; index < suiciders.length; ++index) {
            double thetaRadians = Math.toRadians(theta * index);
            int x = (int) (UIConstants.NODE_CIRCLE_RADIUS * Math.cos(thetaRadians));
            int y = (int) (UIConstants.NODE_CIRCLE_RADIUS * Math.sin(thetaRadians));

            nodesList[index] = new SuiciderNode(
                    UIConstants.NODE_CIRCLE_BIAS_X + x,
                    UIConstants.NODE_CIRCLE_BIAS_Y + y,
                    suiciders[index]
            );
            if (!nodesList[index].isKitsos()) {
                nodesList[index].kill();
            }
        }
        return nodesList;
    }
}
