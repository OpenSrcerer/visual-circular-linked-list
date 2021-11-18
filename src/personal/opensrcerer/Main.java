/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

package personal.opensrcerer;

import personal.opensrcerer.ui.Window;

import javax.swing.*;

/**
 * The main class for the program.
 */
public class Main {
    /**
     * Flag to check whether look and feel change was successful.
     */
    private static boolean lookAndFeelSuccessful = false;

    /**
     * Start the program's execution.
     * @param args Arguments taken in if the program was started from console.
     * @throws UnsupportedLookAndFeelException If neither of the look and feel
     * types are supported.
     */
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        // Try to set the UI look and feel to match the system
        setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        if (!lookAndFeelSuccessful)
            // Revert to a cross-platform version
            setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

        if (!lookAndFeelSuccessful)
            throw new UnsupportedLookAndFeelException("Program is unable to start, provided look and feel-s are incompatible!");

        // Invoke managing of the UI to a specific UI management thread
        SwingUtilities.invokeLater(Window::createAndShowGUI);
    }

    /**
     * Set the look and feel of the system with error handling.
     * @param lfClassName Look and Feel Class Name
     */
    private static void setLookAndFeel(String lfClassName) {
        try {
            UIManager.setLookAndFeel(lfClassName);
            lookAndFeelSuccessful = true;
        } catch (Exception ex) {
            System.out.println("Look and feel is unsupported.");
        }
    }
}
