import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class test {
    public static void testHeap() {
        MyHeap<Integer> heap = new MyHeap<Integer>();
        System.out.println(heap.removeMin());
        heap.add(5);
        heap.add(10);
        heap.add(7);
        heap.add(6);
        heap.add(20);
        heap.add(0);
        heap.printTree(2);
        System.out.println(heap.size());
        heap.removeMin();
        heap.removeMin();
        heap.add(30);
        heap.removeMin();
        heap.add(0);
        heap.printTree(2);
        System.out.println(heap.size());
        System.out.println(heap.toString());
    }
    
    public static void testBST() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        System.out.println(bst.getDepth());
        bst.insert(5);
        System.out.println(bst.getDepth());
        System.out.println(bst.size());
        for (int i = 0; i < 10; i++) {
            bst.insert(i);
        }
        bst.printTree(1);
        System.out.println(bst.getDepth());
        System.out.println(bst.remove(3));
        System.out.println("Divider");
        bst.printTree(1);
        System.out.println(bst.size());
        System.out.println(bst.removeMin());
        System.out.println(bst.toString());
    }
    
    public static void testWithArrayList() {
        ArrayList<Integer> aList = new ArrayList<Integer>();
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        Random rand = new Random();
        int i = 0;
        int head = 0;
        while (aList.toString().equals("[" + list.toString() + "]") && i < 10000) {
            int j = rand.nextInt(8);
            if (j == 0) {
                int index = rand.nextInt(list.size() + 1);
                int element = rand.nextInt(99999);
                aList.add(index, element);
                list.add(index, element);
            }
            if (j == 1) {
                int element = rand.nextInt(99999);
                aList.add(element);
                list.add(element);
            }
            if (j == 2 && list.size() != 0) {
                int index = rand.nextInt(list.size());
                int element = rand.nextInt(99999);
                aList.set(index, element);
                list.set(index, element);
            }
            if (j == 3 && !list.isEmpty()) {
                int index = rand.nextInt(list.size());
                aList.remove(index);
                list.remove(index);
            }
            if (j == 4) {
                int element = rand.nextInt(99999);
                aList.remove(new Integer(element));
                list.remove(new Integer(element));
            }
            if (j == 5 && list.size() != 0) {
                int index = rand.nextInt(list.size());
                if (aList.get(index).compareTo(list.get(index)) != 0) {
                    i = 99999999;
                    System.out.println(aList.get(index) + " " + list.get(index));
                }
            }
            if (j == 6 && list.size() != 0) {
                list.removeHead();
                aList.remove(0);
                head++;
            }
            if (j == 7) {
                int element = rand.nextInt(99999);
                list.addTail(element);
                aList.add(element);
            }
            i++;
        }
        System.out.println(aList.toString().equals("[" + list.toString() + "]") + " " + i + " " + head);
    }

    public static String testRadDeg() {
        boolean notEqual = true;
        int deg = 1;
        int rad = 1;
        while(notEqual) {
            if((rad*.0174)%360 == deg%360) {
                notEqual = false;
            } else {
                deg++;
                rad++;
            }
        }
        return deg + "degrees equals " + rad + "rad";
    }
    
    public static void testCastaways() {
        String[] lastName = {"",
                                    "Grumby",
                                    "Howell",
                                    "Howell",
                                    "Grant",
                                    "Hinkley",
                                    "Summers"};
        String[] firstName = {"Gilligan",
                                    "Jonas",
                                    "Thurston",
                                    "Lovey",
                                    "Ginger",
                                    "Roy",
                                    "Mary Ann"};
        int[] score = {72, 85, 82, 96, 90, 96, 88};
        String[] gender = {"M", "M", "M", "F", "F", "M", "F"};
        MyLinkedList<Castaway> castaways = new MyLinkedList<Castaway>();
        for(int i = 0; i < gender.length; i++) {
                    castaways.insertSorted(new Castaway(lastName[i], firstName[i], score[i]
                            , gender[i]));
        }
        for(int i = 0; i < gender.length; i++) {
            System.out.println(castaways.get(i).toString());
        }   
    }
        
    public static void testOtherThings() {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        list.addHead(3);
        list.addHead(4);
        list.addHead(5);
        list.addHead(3);
        System.out.println(list.toString());
        if (list.size() != 4) {
            System.out.println("Failed size");
        }
        if (list.getHead() != 3) {
            System.out.println("Failed getHead");
        }
        if (list.removeHead() != 3) {
            System.out.println("Failed removeHead");
        }
        if (!list.toString().equals("5, 4, 3")) {
            System.out.println("Failed removeHead " + list.toString());
        }
        list.addTail(2);
        if (!list.toString().equals("5, 4, 3, 2")) {
            System.out.println("Failed addTail " + list.toString());
        }
    }
    
    public static void testLL() {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        if (!list.isEmpty()) {
            System.out.println("Failed isEmpty");
        }
        list.addHead(1);
        list.addHead(2);
        if (list.size() != 2) {
            System.out.println("Failed size");
        }
        if (list.remove(1) == null) {
            System.out.println("Failed remove index, is null");
        }
        if (list.get(0) != 2) {
           System.out.println("Failed get " + list.get(1));
        }
        list.addHead(3);
        list.add(1, 4);
        if (!list.toString().equals("3, 4, 2")) {
            System.out.println("Failed add1 with index " + list.toString());
        }
        list.add(0, 9);
        if (!list.toString().equals("9, 3, 4, 2")) {
            System.out.println("Failed add2 with index " + list.toString());
        }
        if (list.getHead() != 9) {
            System.out.println("Your add method does not set the head variable when inserting at index 0");
        }
        list.add(4, 10);
        list.addTail(5);
        if (list.size() != 6) {
            System.out.println("Failed size");
        }
        if (!list.toString().equals("9, 3, 4, 2, 10, 5")) {
            System.out.println("Your add method does not set the tail variable when inserting at the index equal to the size of the list  " + list.toString());
        }
        list.remove(5);
        list.remove(4);
        
        
        if (list.remove(0) != 9) {
            System.out.println("Failed remove index " + list.toString());
        }
        if (!list.toString().equals("3, 4, 2")) {
            System.out.println("Failed remove index " + list.toString());
        }
        
        list.add(3, 9);
        if (!list.toString().equals("3, 4, 2, 9")) {
            System.out.println("Failed add3 with index " + list.toString());
        }
        list.remove(3);
        
        
        list.set(1, 9);
        if (!list.toString().equals("3, 9, 2")) {
            System.out.println("Failed set " + list.toString());
        }
        list.insertSorted(4);
        if (!list.toString().equals("3, 4, 9, 2")) {
            System.out.println("Failed insertSorted " + list.toString());
        }
        if (list.remove(new Integer(2)) == null) {
            System.out.println("Failed remove element, is null");
        }
        if (!list.toString().equals("3, 4, 9")) {
            System.out.println("Failed remove element " + list.toString());
        }
        MyLinkedList<Integer> listSorted = new MyLinkedList<Integer>();
        listSorted.insertSorted(6);
        listSorted.insertSorted(2);
        listSorted.insertSorted(8);
        listSorted.insertSorted(9);
        listSorted.insertSorted(67);
        listSorted.insertSorted(0);
        listSorted.insertSorted(-6);
        System.out.println(listSorted.integrityCheck());
        if (listSorted.size() != 7) {
            System.out.println("Failed size");
        }
        if (!listSorted.toString().equals("-6, 0, 2, 6, 8, 9, 67")) {
            System.out.println("Failed insertSorted " + listSorted.toString());
        }
        
        
        
        MyStackLL<Integer> stack = new MyStackLL<Integer>();
        try {
            stack.pop();
        } catch (NoSuchElementException e){
            System.out.println("Tried to pop from an empty stack.");
        }
        try {
            stack.top();
        } catch (NoSuchElementException e){
            System.out.println("Tried to top from an empty stack");
        }
        if (!stack.isEmpty()){
            System.out.println("Failed isEmpty");
        }
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        if (stack.size() != 5){
            System.out.println("Failed size");
        }
        if (stack.top() != 5){
            System.out.println("Failed top");
        }
        if (stack.pop() != 5){
            System.out.println("Failed pop");
        }
        if (!stack.toString().equals("4, 3, 2, 1")) {
            System.out.println("Failed toString " + stack.toString());
        }
        
        MyQueueLL<Integer> queue = new MyQueueLL<Integer>();
        if (!queue.isEmpty()){
            System.out.println("Failed isEmpty");
        }
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        if (queue.size() != 5){
            System.out.println("Failed size");
        }
        if (queue.front() != 1){
            System.out.println("Failed front");
        }
        if (queue.dequeue() != 1){
            System.out.println("Failed dequeue");
        }
        if (!queue.toString().equals("2, 3, 4, 5")) {
            System.out.println("Failed toString " + queue.toString());
        }
    }

}
