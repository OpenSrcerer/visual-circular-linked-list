/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

package personal.opensrcerer.entities;

import personal.opensrcerer.circularList.CircularLinkedList;
import personal.opensrcerer.ui.WindowLayout;
import personal.opensrcerer.util.NameGenerator;

/**
 * A specialized CircularLinkedList in a singleton pattern that
 * manages operations about suiciders.
 */
public class SuicideManager extends CircularLinkedList<Suicider> {

    /**
     * Singleton instance for this manager.
     */
    private static SuicideManager manager = null;

    /**
     * The total number of Suicider Nodes.
     */
    private static Integer suiciderNodes = null;

    /**
     * The selected magic number by the user.
     */
    private static Integer magicNumber = null;

    /**
     * Positions of the nodes committing suicide;
     */
    private static int[] snapshots = null;

    /**
     * The selected current step.
     */
    private static int currentStep;

    /**
     * @return The instance of this singleton object.
     */
    public static SuicideManager getInstance() {
        if (manager == null) {
            manager = new SuicideManager();
        }
        return manager;
    }

    /**
     * Set the Suicider Number and Magic Number values input from the user.
     * @param suiciderNodes Suicider nodes value that represents how many nodes
     *                      will "suicide".
     * @param magicNumber Value that shows how the nodes should be killed.
     */
    public static void setValues(Integer suiciderNodes, Integer magicNumber) {
        SuicideManager.suiciderNodes = suiciderNodes;
        SuicideManager.magicNumber = magicNumber;

        if (suiciderNodes == null && magicNumber == null) {
            WindowLayout.viewportPane.reset();
        } else if (suiciderNodes != null && magicNumber != null) {
            WindowLayout.viewportPane.setNodes();
        } else if (suiciderNodes == null) {
            WindowLayout.viewportPane.setMissingSuiciderNumber();
        } else {
            WindowLayout.viewportPane.setMissingMagicNumber();
        }
    }

    /**
     * Given that the configuration of the nodes is set (suiciderNodes / magicNumber),
     * this method returns a list of Suicider-s which represent the arrangement of
     * the real "suiciders" in the circle.
     * It also updates UI components that need to be updated.
     * @return A list of Suiciders.
     */
    public Suicider[] getListOfNodes() {
        CircularLinkedList<Suicider> suiciderList = new CircularLinkedList<>();
        for (int index = 0; index < suiciderNodes; ++index) {
           suiciderList.add(new Suicider(index + 1, ""));
        }
        int kitsosPosition = suiciderList.removeUntilLast(getMagicNumber()).getPosition();

        WindowLayout.banner.setAnnouncement("Kitsos should stay in position " + kitsosPosition + ".");
        NameGenerator.refillNames();
        manager.clear();

        Suicider[] suiciders = new Suicider[suiciderNodes];
        for (int index = 0; index < suiciderNodes; ++index) {
            Suicider suiciderToAdd;
            if (index + 1 == kitsosPosition) {
                suiciderToAdd = new Suicider(index + 1, "Kitsos");
            } else {
                suiciderToAdd = new Suicider(index + 1, NameGenerator.getRandomName());
            }
            manager.add(suiciderToAdd);
            suiciders[index] = suiciderToAdd;
        }
        manager.setSuicideSnapshots(getMagicNumber());
        currentStep = snapshots.length - 1;

        return suiciders;
    }

    /**
     * @return The number of people who will commit suicide.
     */
    public static Integer getSuiciderNodes() {
        return suiciderNodes;
    }

    /**
     * @return Get the selected magic number by the user.
     */
    public static Integer getMagicNumber() {
        return magicNumber;
    }

    /**
     * @return The current node that commits suicide varying on the selected step.
     */
    public static int getSnapshot() {
        return (currentStep == -1) ?
                snapshots[currentStep + 1] : snapshots[currentStep];
    }

    /**
     * Update the current step of the suicide.
     * @param step The step to update to.
     */
    public static void setCurrentStep(int step) {
        if (step < -1) {
            step = -1;
        } else if (step >= snapshots.length) {
            step = snapshots.length - 1;
        }
        SuicideManager.currentStep = step;
    }

    /**
     * @return The currently selected step.
     */
    public static int getCurrentStep() {
        return currentStep;
    }

    /**
     * Set the snapshot array given the magic number.
     * @param n The selected magic number.
     */
    private void setSuicideSnapshots(int n) {
        int originalSize = super.size();
        int[] suicides = new int[originalSize - 1];

        for (int index = 0; index < originalSize - 1; ++index) {
            super.next(n - 1);
            suicides[index] = this.getCurrentValue().getPosition();
            super.deleteCurrent();
        }
        snapshots = suicides;
    }
}
