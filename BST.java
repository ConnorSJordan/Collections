
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
        return search(element);
    }
    
    /**
     * Returns the minimum element in the binary serch tree
     * 
     * @return minimum element in the binary search tree
     */
    public void getMin() {
        //change to E not void;
    }
    
    /**
     * Return the maximun element in the binary search tree
     * 
     * @return maximum element in the binary search tree
     */
    public void getMax() {
        //change to E not void
    }
    
    /**
     * Indicated weather the binary search tree is empty
     * 
     * @return is the binary search tree empty
     */
    public boolean isEmpty() {
        return size==0;
    }
    
    /**
     * Returns the number of elements in the binary search tree
     * 
     * @return the size of the binary search tree
     */
    public int size() {
        return size;
    }
}