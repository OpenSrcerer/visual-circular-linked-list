package personal.opensrcerer.entities;

import personal.opensrcerer.circularList.CircularLinkedList;
import personal.opensrcerer.circularList.CircularNode;

/**
 * A specialized CircularLinkedList that displays output about some of its operations.
 */
public class SuiciderManager extends CircularLinkedList<Suicider> {

    private static SuiciderManager manager = null;

    public static SuiciderManager getInstance() {
        if (manager == null) {
            manager = new SuiciderManager();
        }
        return manager;
    }

    /**
     * Display the contents of the list.
     */
    public void display() {
        CircularNode<Suicider> starting = super.firstElement;
        CircularNode<Suicider> curr = super.firstElement;

        int printCounter = 1;
        do {
            System.out.print(curr.getElement().getName() + "(" + curr.getElement().getPosition() + ")->");
            if (printCounter % 5 == 0) {
                System.out.println();
            }
            curr = curr.getNext();
            ++printCounter;
        } while (!curr.equals(starting));
        if (printCounter % 5 == 0) {
            System.out.println();
        } else {
            System.out.println("\n");
        }
    }

    @Override
    public Suicider removeUntilLast(int n) {
        if (super.size() <= 1) {
            return null;
        }

        System.out.println("The group starts with:");
        this.display();

        super.next(n);
        System.out.println(
                super.getCurrentValue().getName() + " suicides first, in position " +
                super.getCurrentValue().getPosition()
        );
        super.deleteCurrent();
        this.display();
        while (super.size() >= 1) {

            if (super.size() == 1) {
                System.out.println("Now only Kitsos remains, in position " + getCurrentValue().getPosition());
                break;
            }

            super.next(n + 1);

            System.out.println(
                    super.getCurrentValue().getName() + " suicides, in position " +
                            super.getCurrentValue().getPosition()
            );
            super.deleteCurrent();

            System.out.println("These individuals remain:");
            this.display();
        }
        return super.getCurrentValue();
    }
}
