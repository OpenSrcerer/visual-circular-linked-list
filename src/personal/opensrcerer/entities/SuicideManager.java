package personal.opensrcerer.entities;

import personal.opensrcerer.circularList.CircularLinkedList;
import personal.opensrcerer.ui.WindowLayout;
import personal.opensrcerer.ui.components.custom.messages.SuicideInfo;
import personal.opensrcerer.util.NameGenerator;

/**
 * A specialized CircularLinkedList that displays output about some of its operations.
 */
public class SuicideManager extends CircularLinkedList<Suicider> {

    private static Integer suiciderNodes = null;

    private static Integer magicNumber = null;

    private static SuicideManager manager = null;

    private static int[] snapshots = null;

    private static int currentStep;

    public static SuicideManager getInstance() {
        if (manager == null) {
            manager = new SuicideManager();
        }
        return manager;
    }

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

    public static Integer getSuiciderNodes() {
        return suiciderNodes;
    }

    public static Integer getMagicNumber() {
        return magicNumber;
    }

    public static int getSnapshot() {
        return (currentStep == -1) ?
                snapshots[currentStep + 1] : snapshots[currentStep];
    }

    public static void setCurrentStep(int step) {
        if (step < -1) {
            step = -1;
        } else if (step >= snapshots.length) {
            step = snapshots.length - 1;
        }

        SuicideManager.currentStep = step;
    }

    public static int getCurrentStep() {
        return currentStep;
    }

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
