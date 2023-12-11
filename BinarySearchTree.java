import java.util.NoSuchElementException;

/**
 * Creates an abstract data type modeled after a binary search tree
 *
 * @author Connor Jordan
 * @version V1
 */
public class BinarySearchTree<E extends Comparable<E>> {
    private int size;
    private BinarySearchTreeNode<E> root;

    /**
     * Constructor for objects of class BinarySearchTree
     */
    public BinarySearchTree() {
        size = 0;
        root = null;
    }

    /**
     * Inserts element into the binary search tree
     *
     * @param  element  element to be inserted
     */
    public void insert(E element) {
        if (isEmpty()) {
            root = new BinarySearchTreeNode<E>(element);
        } else {
            root.insert(element);
        }
        size++;
    }
    
    /**
     * Searches for and returns the matching element
     * 
     * @param  element  the element to be searched for
     * 
     * @return  the matching element
     */
    public E search(E element) {
        if (isEmpty()) {
            return null;
        } else {
            return root.search(element);
        }
    }
    
    /**
     * Removes and returns the matching element
     * 
     * @param  the element to be removed
     * 
     * @return the matching element;
     */
    public E remove(E element) {
        if (isEmpty()) { // empty
            return null;
        } else if (search(element) == null) { // elem not in tree
            return null;
        } else {
            root = root.remove(element);
            size--;
            return element;
        }
    }
    
    /**
     * Returns the minimum element in the binary serch tree
     * 
     * @return minimum element in the binary search tree
     */
    public E getMin() {
        if (isEmpty()) {
            return null;
        } else {
            return root.getMin();
        }
    }
    
    /**
     * Return the maximun element in the binary search tree
     * 
     * @return maximum element in the binary search tree
     */
    public E getMax() {
        if (isEmpty()) {
            return null;
        } else {
            return root.getMax();
        }
    }
    
    /**
     * Returns the number of levels in the binary search tree
     * 
     * @return the number of levels in the tree
     */
    public int getDepth() {
        if (isEmpty()) {
            return 0;
        } else {
            return root.getDepth() + 1;
        }
    }
    
    /**
     * Removes and returns the minimum element
     * 
     * @return the minimum element in the tree
     */
    public E removeMin() {
        if (isEmpty()) {
            return null;
        } else {
            root.removeMin();
            return getMin();
        }
    }
    
    /**
     * Removes and returns the maximim element
     * 
     * @return the maximum element in the tree
     */
    public E removeMax() {
        if (isEmpty()) {
            return null;
        } else {
            root.removeMax();
            return getMax();
        }
    }
    
    /**
     * Indicated weather the binary search tree is empty
     * 
     * @return is the binary search tree empty
     */
    public boolean isEmpty() {
        return root == null;
    }
    
    /**
     * Returns the number of elements in the binary search tree
     * 
     * @return the size of the binary search tree
     */
    public int size() {
        return size;
    }
    
    /**
     * Prints all of the elements in order smallest to largest
     * 
     * @return  a string of all the elements lowest to highest 
     * seperated by commas
     */
    public String toString() {
        if (isEmpty()) {
            return "";
        } else {
            return root.toString();
        }
    }
    
    /**
     * Mr murphy method; Prints the structure of the tree
     */
    public void printTree(int i) {
        if (!isEmpty()) {
            root.printTree(i);
        }
    }
}
