public class MyArrayList<Type> {

    protected int capacity = 16; //length of the array list and the current max size
    protected Type[] list = (Type[]) new Object[capacity]; //store the elements of the list in this array
    protected int size = 0; //number of elements stored in the list

    //inserts the item at position index
    //any elements after are shuffled down one position
    //if index is greater than size, then do nothing
    //should run in O(i) time, i=number of elements shuffled
    public void insert(Type item, int index) {
        if (size == 0) {
            if (index <= size && index >= 0) {
                list[index] = item;
                size++;
            }
        } else if (index > size && index < capacity) {
            list[index] = item;
            size++;
        } else if (index <= size && index >= 0 && size != capacity) {
            Type[] copyList = (Type[]) new Object[capacity];
            int copyIndex = 0;
            for (int i = index; i < size; i++) {
                copyList[copyIndex] = list[i];
                copyIndex++;
            }
            list[index] = item;
            copyIndex = 0;
            for (int i = index + 1; i < size + 1; i++) {
                list[i] = copyList[copyIndex];
                copyIndex++;
            }
            size++;
        }
        if (size == capacity && size != 0) {
            resize();
        }
    }

    //removes the element at position index and returns the element
    //any elements after are shuffled down to fill in
    //if index is out of bounds, does nothing and return null
    //should run in O(i) time, i=number of elements shuffled
    public Type remove(int index) {
        if (index > size || index < 0) {
            return null;
        }
        Type holder = list[index];
        for (int i = index; i < size; i++) {
            list[i] = list[i + 1];
        }
        size--;
        return holder;
    }

    //searches the list for the item and returns true if found
    //should run in O(n) time
    public boolean contains(Type item) {
        int contains = 0;
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                contains = 1;
                break;
            }
        }
        return contains == 1;
    }

    //searches the list for the item and returns the index if found, -1 if otherwise
    //should run in O(n) time
    public int indexOf(Type item) {
        int itemIndex = -1;
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                itemIndex = i;
                break;
            }
        }
        return itemIndex;
    }

    //returns the element stored at index and null if index is out of bounds
    //should run in O(1) time
    public Type get(int index) {
        if (index >= size || index < 0) {
            return null;
        } else {
            return list[index];
        }
    }

    //updates the elements stored at index and does nothing if the index is out of bounds
    //should run in O(1) time
    public void set(int index, Type item) {
        if (index <= size && index >= 0) {
            list[index] = item;
        }
    }

    //returns the field size
    //should run in O(1) time
    public int size() {
        return size;
    }

    //returns true is the size is 0 and false otherwise
    //should run in O(1) time
    public boolean isEmpty() {
        return size == 0;
    }

    //returns a string that has the contents of the list separated by commas and spaces in []
    //should run in O(n) time
    public String toString() {
        Type element;
        String arrayString = "[";
        for (int i = 0; i < size; i++) {
            element = list[i];
            if (i == 0) {
                arrayString = arrayString + element;
            } else {
                arrayString = arrayString + ", " + element ;
            }
        }
        arrayString = arrayString + "]";
        return arrayString;
    }

    //called by insert when the list is full
    //doubles the capacity of the list and copies the elements into a new array
    //should run in O(n) time
    protected void resize() {
        capacity = capacity * 2;
        Type[] copyList = (Type[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            copyList[i] = list[i];
        }
        list =  copyList;
    }
}
