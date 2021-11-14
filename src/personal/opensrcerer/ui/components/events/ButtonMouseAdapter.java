package personal.opensrcerer.ui.components.events;

import personal.opensrcerer.ui.Window;
import personal.opensrcerer.ui.styling.DiscordColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButtonMouseAdapter extends MouseAdapter {

    private final JButton button;

    public ButtonMouseAdapter(JButton button) {
        this.button = button;
    }

    @Override
    public void mouseEntered(MouseEvent evt) {
        Window.contentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBackground(DiscordColor.lessGray.get());
    }

    @Override
    public void mouseExited(MouseEvent evt) {
        Window.contentPane().setCursor(Cursor.getDefaultCursor());
        button.setBackground(DiscordColor.regularGray.get());
    }

    @Override
    public void mousePressed(MouseEvent evt) {
        button.setBackground(DiscordColor.regularGray.get());
    }
}
