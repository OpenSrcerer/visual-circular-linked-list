package personal.opensrcerer.entities;

/**
 * The Data class that keeps information
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
