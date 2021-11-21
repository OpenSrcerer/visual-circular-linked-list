/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

package personal.opensrcerer.ui;

import javax.swing.*;
import java.awt.*;

/**
 * A JFrame with custom methods for convenience.
 * Uses the singleton pattern.
 */
public class Window extends JFrame {
    /**
     * Main window where everything occurs! Only created once.
     */
    private static Window windowSingleton;

    /**
     * Create a new window with a default title.
     */
    private Window() {
        super("Kitsos' Program");
        windowSingleton = this;
    }

    /**
     * Build the window singleton.
     */
    public static void build() {
        if (windowSingleton == null) {
            windowSingleton = new Window();
        }
    }

    /**
     * @return The window singleton instance.
     */
    public static Window get() {
        return windowSingleton;
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    public static void createAndShowGUI() {
        build();
        windowSingleton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the exit operation for this window
        WindowLayout.set(); // Set the elements of the Content Pane
        // Pack the window so that the components
        // get their preferred size assigned.
        updateJFrame();
        windowSingleton.setResizable(false); // Make window non-resizable
        windowSingleton.setVisible(true); // Display the window.
    }

    /**
     * @return The content pane for the singleton Window JFrame.
     */
    public static Container contentPane() {
        return windowSingleton.getContentPane();
    }

    /**
     * Packs, revalidates and repaints the singleton Window JFrame to correctly fit a new layout.
     */
    public static void updateJFrame() {
        windowSingleton.pack(); // Fit size of JFrame
        windowSingleton.revalidate(); // Mark JFrame as "dirty"
        windowSingleton.repaint();
        windowSingleton.setLocationRelativeTo(null); // Center window
    }
}
