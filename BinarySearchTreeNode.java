public class BinarySearchTreeNode<E extends Comparable<E>> {
    private BinarySearchTreeNode<E> left;
    private BinarySearchTreeNode<E> right;
    private E data;

    public BinarySearchTreeNode(E data) {
        this.data = data;
        left = null;
        right = null;
    }
    
    public void insert(E element) {
        if (data.compareTo(element ) > 0) {
            if (left == null) {
                left = new BinarySearchTreeNode<E>(element);
            } else {
                left.insert(element);
            }
        } else {
            if (right == null) {
                right = new BinarySearchTreeNode<E>(element);
            } else {
                right.insert(element);
            }
        }
    }
    
    public BinarySearchTreeNode remove(E element) { // assume element is in array
         if (element.compareTo(data) > 0) { // element could be a non int, use compare to
            if (right == null) {
                return this;
            } else {
                right = right.remove(element);
                return this;
            }
        } else if (element.compareTo(data) < 0) {
            if (left == null) {
                return this;
            } else {
                left = left.remove(element);
                return this;
            }
        } else {
            if (left == null && right == null) {
                data = null;
                return null;
            } else if (right == null) {
                data = null;
                return left;
            } else if (left == null) {
                data = null;
                return right;
            } else {
                data = left.getMax();
                left.removeMax();
                return this;
            }
        }
    }
    
    public BinarySearchTreeNode<E> removeMin() { // assume tree has values
        if(left == null) {
            data = null;
            return null;
        } else {
            left = left.removeMin();
            return this;
        }
    }
    
    public BinarySearchTreeNode<E> removeMax() { // assume tree has values
        if(right == null) {
            data = null;
            return null;
        } else {
            right = right.removeMin();
            return this;
        }
    }
    
    public E search(E element) {
        if (element.compareTo(data) < 0) {
            if (left == null) {
                return null;
            } else {
                return left.search(element);
            }
        } else if (element.compareTo(data) > 0) {
            if (right == null) {
                return null;
            } else {
                return right.search(element);
            }
        } else {
            return data;
        }
    }
    
    public E getMin() {
        if(left == null) {
            return data;
        } else {
            return left.getMin();
        }
    }
    
    public E getMax() {
        if(right == null) {
            return data;
        } else {
            return right.getMax();
        }
    }
    
    public int getDepth() {
        if(left  == null && right == null) {
            return 0; // maybe 1?
        } else if (left == null) {
            return right.getDepth() + 1;
        } else if (right == null) {
            return left.getDepth() + 1;
        }
        else {
            if (left.getDepth() >= right.getDepth()) {
                return left.getDepth() + 1;
            } else {
                return right.getDepth() + 1;
            }
        }
    }
    
    public E getData() {
        return data;
    }
    
    public void setData(E newData) {
        data = newData;
    }
    
    public BinarySearchTreeNode<E> getLeft()
    {
        return left;
    }
    
    public void setLeft(BinarySearchTreeNode<E> newLeft) {
        left = newLeft;
    }
    
    public BinarySearchTreeNode<E> getRight()
    {
        return right;
    }
    
    public void setGreater(BinarySearchTreeNode<E> newRight) {
        right = newRight;
    }
    
    public String toString() {
        String returned = "";
        
        if (left != null) {
            returned = left.toString() + ", ";
        } 
        
        returned = returned + data.toString();
        
        if (right != null) {
            returned = returned + ", " + right.toString();
        }
        return returned;
    }
    
     /**     * Prints elements as stored in the tree
     *
     * @param maxElementWidth The maximum space allowed for the string form
     *                        of the element.
     */
    public void printTree(int maxElementWidth) {
        int maxSize = (int) Math.pow(2, (getDepth() + 1));
        String[] elements = new String[maxSize];

        // Build array of elements
        printTree(elements, 0, maxElementWidth);

        // Print element properly spaced
        int fullWidth = (int) Math.pow(2, getDepth()) * (maxElementWidth + 1);
        for (int i = 0; i < getDepth() + 1; i++) {
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
    private void printTree(String[] elements, int nodeNum, int maxElementWidth) {
        elements[nodeNum] = data.toString();
        if (elements[nodeNum].length() > maxElementWidth) {
            elements[nodeNum] = elements[nodeNum].substring(0, maxElementWidth);
        }
        if (left != null) {
            left.printTree(elements, (nodeNum + 1) * 2 - 1, maxElementWidth);
        }
        if (right != null) {
            right.printTree(elements, (nodeNum + 1) * 2, maxElementWidth);
        }
    }
}
