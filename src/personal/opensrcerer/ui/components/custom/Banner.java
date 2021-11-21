/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

package personal.opensrcerer.ui.components.custom;

import personal.opensrcerer.ui.components.regular.KLabel;
import personal.opensrcerer.ui.components.regular.KPanel;
import personal.opensrcerer.ui.styling.DiscordColor;
import personal.opensrcerer.ui.styling.Fonts;

import java.awt.*;

/**
 * The top banner that contains the announcement text.
 */
public class Banner extends KPanel {

    /**
     * The text that displays which position Kitsos should stay in.
     */
    private String announcement = "";

    /**
     * The label that contains this banner's text.
     */
    private final KLabel bannerText;

    /**
     * Create a new preset banner.
     */
    public Banner() {
        super();
        this.setPreferredSize(new Dimension(500, 45));
        bannerText = new KLabel("", Fonts.bigTitleFont);
        this.add(bannerText, BorderLayout.CENTER);
        this.setBackground(DiscordColor.darkPurple.get());
    }

    /**
     * Updates the banner's message to the given text.
     * @param text Text to update banner to.
     */
    public void update(String text) {
        // Show the round message if the current player is not a bot.
        bannerText.setText(text);
        this.refresh();
    }

    /**
     * Reset the banner to the announcement message.
     */
    public void update() {
        bannerText.setText(this.announcement);
        this.refresh();
    }

    /**
     * Set the announcement message.
     * @param announcement Message to set.
     */
    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
        this.refresh();
    }

    /**
     * Revalidate and repaint this component.
     */
    private void refresh() {
        this.revalidate();
        this.repaint();
    }
}