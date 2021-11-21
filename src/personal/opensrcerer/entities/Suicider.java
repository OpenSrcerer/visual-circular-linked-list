/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

package personal.opensrcerer.entities;

/**
 * The class that stores information
 * about the individuals who will suicide.
 */
public class Suicider {
    /**
     * The position of the suicider.
     */
    private final int position;

    /**
     * The name of the suicider.
     */
    private final String name;

    /**
     * Create a new Suicider.
     * @param position Position of suicider.
     * @param name Name of suicider.
     */
    public Suicider(int position, String name) {
        this.position = position;
        this.name = name;
    }

    /**
     * @return Suicider's position.
     */
    public int getPosition() {
        return position;
    }

    /**
     * @return Suicider's name.
     */
    public String getName() {
        return name;
    }
}
