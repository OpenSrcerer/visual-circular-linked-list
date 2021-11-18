package personal.opensrcerer.entities;

import personal.opensrcerer.circularList.CircularLinkedList;
import personal.opensrcerer.ui.WindowLayout;
import personal.opensrcerer.util.NameGenerator;

/**
 * A specialized CircularLinkedList that displays output about some of its operations.
 */
public class SuiciderManager extends CircularLinkedList<Suicider> {

    private static Integer suiciderNodes = null;

    private static Integer magicNumber = null;

    private static SuiciderManager manager = null;

    private static int[] snapshots = null;

    private static int currentStep;

    public static SuiciderManager getInstance() {
        if (manager == null) {
            manager = new SuiciderManager();
        }
        return manager;
    }

    public static void setValues(Integer suiciderNodes, Integer magicNumber) {
        SuiciderManager.suiciderNodes = suiciderNodes;
        SuiciderManager.magicNumber = magicNumber;

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
        snapshots = manager.getSuicideSnapshots(getMagicNumber());
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
        return snapshots[currentStep];
    }

    public static void setCurrentStep(int currentStep) {
        if (currentStep < 0) {
            currentStep = 0;
        } else if (currentStep >= snapshots.length) {
            currentStep = snapshots.length - 1;
        }

        SuiciderManager.currentStep = currentStep;
    }

    public static int getCurrentStep() {
        return currentStep;
    }

    private int[] getSuicideSnapshots(int n) {
        if (super.size() <= 1) {
            return null;
        }

        int originalSize = super.size();
        int[] suicides = new int[originalSize - 1];

        for (int index = 0; index < originalSize - 1; ++index) {
            super.next(n - 1);
            suicides[index] = this.getCurrentValue().getPosition();
            super.deleteCurrent();
        }
        return suicides;
    }
}
