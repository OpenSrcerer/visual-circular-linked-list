/*
 * Made for the Project in CS215, due November 22nd 2021.
 * This work is licensed under the GNU General Public License v3.0
 * GNU © 2021 Daniel Stefani / OpenSrcerer
 */

package personal.opensrcerer.circularList;

/**
 * This class is a node for the Circular Linked List.
 * @param <E> Type of data to contain.
 */
public class CircularNode<E> {
    /**
     * The current element in the node.
     */
    protected final E element;

    /**
     * The next element in the node.
     */
    protected CircularNode<E> next;

    /**
     * Create a new CircularNode with the given data.
     * @param data Data to store.
     */
    protected CircularNode(E data) {
        this.element = data;
    }

    /**
     * @return The value contained in this node.
     */
    public E getElement() {
        return element;
    }

    /**
     * @return The next node after the current.
     */
    public CircularNode<E> getNext() {
        return next;
    }
}