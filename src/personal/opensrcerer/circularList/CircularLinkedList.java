/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

package personal.opensrcerer.circularList;

import java.util.Arrays;

/**
 * An implementation of a Circular Linked List that is used in this project to pass turns in a circular fashion.
 * The structure of the List is generified to maintain compatibility but in the project, the Type argument E is a Player object.
 * @param <E> The type of data that this list contains.
 */
public class CircularLinkedList<E> {

    /**
     * The first element in the list.
     */
    protected CircularNode<E> firstElement = null;

    /**
     * The current node on the list.
     */
    protected CircularNode<E> current = null;

    /**
     * The previous node of the list.
     */
    protected CircularNode<E> previous = null;

    /**
     * Contains the number of elements in this linked list.
     */
    protected int size;

    /**
     * Construct a new CircularLinkedList with no elements.
     */
    public CircularLinkedList() {
    }

    /**
     * Construct a new CircularLinkedList from an array.
     * @param elements The array that contains the elements this list will start out with.
     */
    public CircularLinkedList(E[] elements) {
        Arrays.stream(elements).forEach(this::add);
    }

    /**
     * Add an element to this LinkedList.
     * @param data Data to insert.
     */
    public void add(E data) {
        this.insert(data);
        this.next();
        ++size;
    }

    /**
     * Advance this LinkedList by one node.
     */
    public void next() {
        if (current != null) {
            previous = current; // Make the current node the previous node
            current = previous.next; // Advance the current node
        }
    }

    /**
     * Advance this list by N nodes.
     * @param n Number to advance list by.
     */
    public void next(int n) {
        for (int i = 0; i < n; ++i) {
            if (current != null) {
                previous = current; // Make the current node the previous node
                current = previous.next; // Advance the current node
            }
        }
    }

    /**
     * Insert new data into the Linked List as a new node.
     * @param data The new data to insert.
     */
    private void insert(E data) {
        CircularNode<E> newNode = new CircularNode<>(data);
        if (current == null) { // Case if the list is empty
            firstElement = newNode;
            previous = newNode;
            current = newNode;
            newNode.next = newNode;
        } else {
            // Make the new Node the current node but leave the previous node unchanged
            previous.next = newNode;
            newNode.next = current;
            current = newNode;
        }
    }

    /**
     * Removes the current node.
     */
    protected void deleteCurrent() {
        if (size() == 0) {
            return;
        }

        if (firstElement.equals(current)){
            firstElement = current.next;
        }

        current = current.next;
        if (previous != null) {
            previous.next = current;
        }
        --size;
    }

    /**
     * @return The size of this LinkedList.
     */
    public int size() {
        return size;
    }

    /**
     * @return The current element of the list.
     */
    public E getCurrentValue() {
        return current.element;
    }

    /**
     * This method removes nodes from the list in the following fashion:
     * Firstly, it advances and removes the n-th node. Then, it removes
     * every n-th node starting from the node after it was removed.
     * The method returns the original position of node that remains.
     *
     * If list has 1 or no elements, it remains unchanged and the method returns nul.
     * @param n The N number to perform this operation with.
     * @return The last element remaining.
     */
    public E removeUntilLast(int n) {
        if (size() <= 1) {
            return null;
        }

        this.next(n - 1);
        deleteCurrent();
        while (size() >= 1) {
            this.next(n - 1);
            deleteCurrent();
        }
        return current.element;
    }

    /**
     * Remove all the elements in this list.
     */
    public void clear() {
        this.firstElement = null;
        this.current = null;
        this.previous = null;
    }
}