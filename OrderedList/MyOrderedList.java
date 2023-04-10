public class MyOrderedList<Type extends Comparable<Type>> {

    protected MyArrayList<Type> list = new MyArrayList<Type>();
    long comparisons;

    //adds the item to the position in the list where it belongs
    //should run in O(n) time in worst case
    public void add(Type item) {
        //add the new item to the end of the list
        //swap the item with left if left is greater than item
            //repeat until in correct place
        list.insert(item, list.size());
        int currentIndex = list.size() - 1;
        comparisons++;
        while (currentIndex != 0 && list.get(currentIndex - 1).compareTo(list.get(currentIndex)) > 0) {
            Type temp = list.get(currentIndex);
            list.set(currentIndex, list.get(currentIndex - 1));
            list.set(currentIndex - 1, temp);
            currentIndex --;
            comparisons++;
        }
        //binary search for position
        //call insert
        //faster??
    }

    //removes the item from the list if found
    //should run in O(n) time
    public Type remove (Type item) {
        int removeIndex = list.indexOf(item);
        Type removedItem = list.remove(removeIndex);
        return removedItem;
    }

    //uses a binary search to search the list for the item
    //returns true if found
    //should run in O(lgn) time
    public boolean binarySearch(Type item) {
        //can implement with loop or recursion
        int low = 0;
        int high = list.size() - 1;
        int contains = 0;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            Type value = list.get(middle);
            if (value.compareTo(item) < 0) {
                low = middle + 1;
            } else if (value.compareTo(item) > 0) {
                high = middle - 1;
            } else {
                contains = 1;
            }
            comparisons++;
        }
        return contains == 1; //if contains is 1 then item exists
    }

    //returns the size of the list
    //should run in O(1)
    public int size() {
        return list.size();
    }

    //returns true if the size is 0
    //should run in O(1)
    public boolean isEmpty() {
        return list.isEmpty();
    }

    //returns a string that has the contents of the list
    //should run in O(n)
    public String toString() {
        return list.toString();
    }
}
