import java.util.Arrays;
/**
 * Creates a binary tree modeled after a heap
 *
 * @author Connor Jordan
 * @version V1
 */
public class MyHeap<E extends Comparable<E>> {
    private E[] elemArray;
    private int lastNode;

    /**
     * Constructor for objects of class MyHeap
     */
    public MyHeap() {
        elemArray = (E[]) new Comparable[2];
        lastNode = -1;
    }

    /**
     * Adds the inputed element into the heap
     *
     * @param  element  the element to insert into the heap
     */
    public void add(E element) {
        if(elemArray.length - 1 == lastNode) {
            elemArray = Arrays.copyOf(elemArray, lastNode + 5);
        } else if (isEmpty()) { // empty array
            elemArray[0] = element;
            lastNode++;
        } else {
            elemArray[lastNode + 1] = element;
            lastNode++;
            int childSpot = lastNode;
            int parentSpot = (childSpot - 1)/2;
            
            while(elemArray[childSpot].compareTo(elemArray[parentSpot]) < 0) {
                E temp = elemArray[childSpot];
                elemArray[childSpot] = elemArray[parentSpot];
                elemArray[parentSpot] = temp;
                
                childSpot = parentSpot;
                parentSpot = (childSpot - 1) / 2;
            }
        }
    }
    
    /**
     * Gets the minimum element from the heap
     * 
     * @return  the minimum element in the heap
     */
    public E getMin() {
        if (isEmpty()) {
            return null;
        } else {
            return elemArray[0];
        }
    }
    
    /**
     * Removes and returns minimum element from heap
     * 
     * @return  the minimum element in the heap
     */
    public E removeMin() {
        if(isEmpty()) {
            return null;
        } else {
            E toBeReturned = getMin();
            elemArray[0] = elemArray[lastNode];
            elemArray[lastNode] = null;
            int parentPosition = 0;
            int leftIndex = (parentPosition * 2) + 1;
            int rightIndex = (parentPosition * 2) + 2;
            lastNode--;
            E temp = elemArray[parentPosition];
            
            while ((parentPosition * 2) + 1 < lastNode && rightIndex < lastNode) {
                temp = elemArray[parentPosition];
                if (elemArray[leftIndex].compareTo(elemArray[rightIndex]) < 0) {
                    elemArray[parentPosition] = elemArray[leftIndex];
                    elemArray[leftIndex] = temp;
                    parentPosition = parentPosition * 2 + 1;
                } else {
                    elemArray[parentPosition] = elemArray[rightIndex];
                    elemArray[rightIndex] = temp;
                    parentPosition = parentPosition * 2 + 2;
                }
            }
            
            if (elemArray[(parentPosition * 2) + 2] != null) {
                if (elemArray[leftIndex].compareTo(elemArray[rightIndex]) < 0) {
                    elemArray[parentPosition] = elemArray[leftIndex];
                    elemArray[leftIndex] = temp;
                    parentPosition = parentPosition * 2 + 1;
                } else {
                    elemArray[parentPosition] = elemArray[rightIndex];
                    elemArray[rightIndex] = temp;
                    parentPosition = parentPosition * 2 + 2;
                }
            } else if (elemArray[leftIndex] != null) {
                elemArray[parentPosition] = elemArray[leftIndex];
                elemArray[leftIndex] = temp;
                parentPosition = parentPosition * 2 + 1;
            }
            
            return toBeReturned;
        }    
    }
    
    /**
     * Indicates weather the heap is empmty
     * 
     * @return  if the heap is empty
     */
    public boolean isEmpty() {        
        return size() == 0;
    }
    
    /**
     * Returns number of elements in the heap
     * 
     * @return  the size
     */
    public int size() {
        return lastNode + 1;
    }
    
    public String toString() {
        return Arrays.toString(elemArray);
    }
    
    /**
     * Prints elements as stored in the tree
     *
     * @param maxElementWidth The maximum space allowed for the string form
     *                        of the element.
     */
    public void printTree(int maxElementWidth) {
        int depth = (int) (Math.log(lastNode + 1) / Math.log(2)) + 1;
        int maxSize = (int) Math.pow(2, depth) - 1;
        String[] elements = new String[maxSize];

        // Build array of elements
        printTree(elements, maxElementWidth);

        // Print element properly spaced
        int fullWidth = (int) Math.pow(2, depth - 1) * (maxElementWidth + 1);
        for (int i = 0; i < depth; i++) {
            String connectionsLevel = "";
            String elementsLevel = "";

            for (int j = (int) Math.pow(2, i) - 1; j < (int) Math.pow(2, i + 1) - 1; j++) {

                // Process arrows for this level
                String arrow = "  ";
                int elementLength = arrow.length();
                if (elements[j] != null) {
                    if (j % 2 == 1) { // Odd is left child
                        arrow = " /";
                    } else { // Even is right child
                        arrow = "\\ ";
                    }
                }

                // Center within maxElementWidth
                String leftPadStr = ""; // Default
                String rightPadStr = ""; // Default
                int leftPadNum = (fullWidth / (int) Math.pow(2, i) - elementLength) / 2;
                int rightPadNum = fullWidth / (int) Math.pow(2, i) - elementLength - leftPadNum;
                if (leftPadNum > 0) {
                    leftPadStr = String.format("%" + leftPadNum + "s", " ");
                }
                if (rightPadNum > 0) {
                    rightPadStr = String.format("%" + rightPadNum + "s", " ");
                }
                connectionsLevel += leftPadStr + arrow + rightPadStr;

                // Process elements for this level
                elementLength = 0;
                if (elements[j] != null) {
                    elementLength = elements[j].toString().length();
                }

                // Center within maxElementWidth
                leftPadStr = ""; // Default
                rightPadStr = ""; // Default
                leftPadNum = (fullWidth / (int) Math.pow(2, i) - elementLength) / 2;
                rightPadNum = fullWidth / (int) Math.pow(2, i) - elementLength - leftPadNum;
                if (leftPadNum > 0) {
                    leftPadStr = String.format("%" + leftPadNum + "s", " ");
                }
                if (rightPadNum > 0) {
                    rightPadStr = String.format("%" + rightPadNum + "s", " ");
                }

                if (elements[j] != null) {
                    elementsLevel += leftPadStr + elements[j] + rightPadStr;
                } else {
                    elementsLevel += leftPadStr + rightPadStr;
                }
            }

            if (i > 0) { // Do not print arrows for root
                System.out.println(connectionsLevel);
            }
            System.out.println(elementsLevel);
        }
    }

    // build array of element strings
    private void printTree(String[] elements, int maxElementWidth) {
        for (int i = 0; i <= lastNode; i++) {
            elements[i] = elemArray[i].toString();
        }
    }
}
