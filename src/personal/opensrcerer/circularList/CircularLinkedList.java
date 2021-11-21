/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

package personal.opensrcerer.circularList;

import java.util.Arrays;

/**
 * An implementation of a Circular Linked List that is
 * used in this project to pass turns in a circular fashion.
 * The structure of the List is generified to demonstrate
 * the flexibility of this data structure.
 * @param <E> The type of data that this list contains.
 */
public class CircularLinkedList<E> {

    /**
     * The first node in the list.
     */
    protected CircularNode<E> firstElement = null;

    /**
     * The current node on the list.
     */
    protected CircularNode<E> current = null;

    /**
     * The next node after the current one.
     */
    protected CircularNode<E> next = null;

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
        // Stream all elements and add each of them to this list.
        Arrays.stream(elements).forEach(this::add);
    }

    /**
     * Add an element to this LinkedList.
     * @param data Data to insert.
     */
    public void add(E data) {
        this.insert(data); // Step 1: Insert the node
        this.next(); // Step 2: Advance the list by one element
        ++size; // Step 3: Increase the list size
    }

    /**
     * Advance this LinkedList by one node.
     */
    public void next() {
        // Step 1: Check if the current node is non-null (list is not empty)
        if (current != null) {
            next = current; // Step 2: Set the next node to the current node.
            current = next.next; // Step 3: Set the current node to the node after the current
        }
    }

    /**
     * Advance this list by N nodes.
     * @param n Number to advance list by.
     */
    public void next(int n) {
        // For the given number N iterate
        for (int i = 0; i < n; ++i) {
            this.next(); // Advance to the next element
        }
    }

    /**
     * Insert new data into the Linked List as a new node.
     * @param data The new data to insert.
     */
    private void insert(E data) {
        // Step 0: Create a new node with the data
        CircularNode<E> newNode = new CircularNode<>(data);

        // Step 1a: Check if list is empty
        if (current == null) {
            firstElement = newNode; // Step 2a: Set the first node to the new node
            next = newNode; // Step 3a: Set the next node to the new node
            current = newNode; // Step 4a: Set the current element to the new node
            newNode.next = newNode; // Step 5a: Point the current node's next to itself
        } else { // If the list is not empty
            next.next = newNode; // Step 2b: Set the next node's next node to the new node
            newNode.next = current; // Step 3b: Set the new node's next to the current
            current = newNode; // Step 4b: Set the current node to the new one
        }
    }

    /**
     * Removes the current node.
     */
    protected void deleteCurrent() {
        // Step 0: Check if list is empty.
        if (size() == 0) {
            return; // Exit if list is empty.
        }

        // Step 1a: Check if the first node is the current node
        if (firstElement.equals(current)){
            // Step 1b: If it is, set the first element to the node after the first.
            firstElement = current.next;
        }

        current = current.next; // Step 2: Set the current element to the one after the current
        if (next != null) { // Step 3: If the next node is not null
            next.next = current; // Step 4: Set the node after the next node to the current.
        }
        --size; // Step 5: Decrement this list's size
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
     * It advances the list by n - 1 nodes, then removes the current node
     * at the time.
     *
     * If list has 1 or no elements, it remains unchanged and the method returns null.
     * @param n The N number to perform this operation with.
     */
    public E removeUntilLast(int n) {
        // Step 0a: Check if the list has one element or is empty
        if (size() <= 1) {
            return null; // Step 0b: Return null if so
        }
        while (size() >= 1) {
            this.next(n - 1); // Step 1: Advance the list by n - 1 nodes.
            deleteCurrent(); // Step 2: Delete the current node.
        }
        return current.element; // Step 3: Return the remaining node.
    }

    /**
     * Remove all the elements in this list.
     */
    public void clear() {
        this.size = 0; // Step 1: Set the size to 0.
        this.firstElement = null; // Step 2: Set the first element to null.
        this.current = null; // Step 3: Set the current element to null.
        this.next = null; // Step 4: Set the next element to null.
    }
}