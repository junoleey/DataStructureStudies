public class MyPriorityQueue<Type extends Comparable<Type>> {

    protected MyArrayList<Type> heap = new MyArrayList<Type>();

    //inserts the item into the heap
    //corrects the invariant
    //should run in O(lgn)
    public void insert(Type item) {
        //inserts the item at the end of the array list
        // calls bubbleUp to move the item to correct location
        heap.insert(item, heap.size());
        bubbleUp();
    }

    //removes the first element and corrects the invariant
    //should run in O(lgn)
    public Type removeMin() {
        //swaps the first element with last element
        //removes the last element
        //calls sinkDown to move the first element to correct location
        //returns element removed
        if (heap.size() == 0) {
            return null;
        }
        Type temp = heap.get(0); //stores first element in temp
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        sinkDown();
        return temp;
    }

    //returns the first element
    //should run in  O(1)
    public Type min() {
        return heap.get(0);
    }

    //returns number of elements in heap
    //should run in O(1)
    public int size() {
        return heap.size();
    }

    //returns true if heap is empty, false otherwise
    //should run in O(1)
    public boolean isEmpty() {
        return heap.size() == 0;
    }

    //returns the contents of the heap in a String
    //should run in o(1)
    public String toString() {
        return heap.toString();
    }

    //shifts the last element up to a position where it belongs
    //should run in O(lgn)
    protected void bubbleUp() {
        //if the element is less than its parent
        //swap the element with its parent
        //repeat with new parent if it exists
        //should use the compareTo method to compare elements
        int currentIndex = heap.size() - 1;
        while (currentIndex != 0 && heap.get(currentIndex).compareTo(heap.get(parent(currentIndex))) < 0) {
            Type temp = heap.get(currentIndex);
            heap.set(currentIndex, heap.get(parent(currentIndex)));
            heap.set(parent(currentIndex), temp);
            currentIndex = parent(currentIndex);
        }
    }

    //shifts the first element down to a position where it belongs
    //should run in O(lgn)
    protected void sinkDown() {
        //if the element is less than at least one of its children
        //swap the elements with its smallest child
        //repeat with the new children if they exist
        //should use the compareTo method
        int currentIndex = 0;
        while (heap.get(left(currentIndex)) != null) { //while left child exists
            Type temp = heap.get(currentIndex);
            int smallerChild = left(currentIndex);
            if (heap.get(right(currentIndex)) != null && heap.get(left(currentIndex)).compareTo(heap.get(right(currentIndex))) >= 0) { //if right child exists and is smaller than left
                smallerChild = right(currentIndex);
            }
            if (heap.get(currentIndex).compareTo(heap.get(smallerChild)) > 0) {
                heap.set(currentIndex, heap.get(smallerChild));
                heap.set(smallerChild, temp);
                currentIndex = smallerChild;
            } else {
                break;
            }
        }
    }

    //returns the index of the parent node in the heap
    //should run in O(1)
    protected int parent(int index) {
        return ((index - 1) / 2);
    }

    //returns the index of the left child node in the heap of the index passed in
    //should run in O(1)
    protected int right(int index) {
        return ((index * 2) + 2);
    }

    //returns the index of the right child node in the heap of the index passed in
    //should run in O(1)
    protected int left(int index) {
        return ((index * 2) + 1);
    }
}
