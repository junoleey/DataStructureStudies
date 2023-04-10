public class MyLinkedList<Type> {

    protected Node first = null;
    protected Node current = first;
    protected Node previous = null;
    protected int size = 0;

    //adds the item before the current Node
    //if the current Node is null, the new element is added in the last position
    //should run in O(1) time
    public void addBefore (Type item) {
        Node newNode = new Node(item);
        if (first == null) {
            first = newNode;
            previous = first;
        } else if (previous == first) {
            first.next = newNode;
            previous = first.next;
        } else {
            newNode.next = current;
            previous.next = newNode;
            previous = newNode;
        }
        size++;
    }

    //adds the item after the current Node
    //if current Node is null, does nothing
    //should run in O(1) time
    public void addAfter (Type item) { //do i have to update previous???
        Node newNode = new Node(item);
        if (current != null && size != 0) {
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    //returns the item stored in the current node
    //returns null if the current Node is null
    //should run in O(1) time
    public Type current() {
        if (current == null) {
            return null;
        } else {
            return current.item;
        }
    }

    //sets the current Node to be the first Node
    //returns the item stored in it
    //returns null if the first Node is null
    //should run in O(1) time
    public Type first() {
        current = first;
        previous = null;
        return current.item;
    }

    //sets the current Node to be the next Node in the list
    //returns the item stored in it
    //returns null if the current node is null
    //should run in O(1) time
    public Type next() {
        previous = current;
        current = current.next;
        return current.item;
    }

    //removes the current Node and returns the element
    //any elements after are shuffled down
    //if the current Node is null, does nothing
    //after this method, the current Node will be equal to the node after removing it
    //should run in O(1) time
    public Type remove() {
        Type currentItem = null;
        if (current == null) { //if current is null
            return null;
        } else if (current == first) { //if current is the first item
            currentItem = current.item;
            first = first.next;
            current = first;
        } else if (current.next == null) { //if current is the last item
            currentItem = current.item;
            previous.next = null;
        } else { //if current is in the middle
            currentItem = current.item;
            previous.next = current.next;
            current = current.next;
        }
        size--;
        return currentItem;
    }

    //searches the Nodes for the item and returns true if found
    //should run in O(n) time
    public boolean contains(Type item) {
        int contains = 0;
        Node temp = first;
        while (temp != null) {
            if (temp.item.equals(item)) {
                contains = 1;
                break;
            }
            temp = temp.next;
        }
        return contains == 1;
    }

    //returns the field size
    //should run in O(1) time
    public int size() {
        return size;
    }

    //returns true if the size is 0 and false otherwise
    //should run in O(1) time
    public boolean isEmpty() {
        return size == 0;
    }

    //returns a string that has the contents of the Node
    //separated by commas, spaces and []
    //should run in O(n) time
    public String toString() {
        String nodeString = "[";
        Node temp = first;
        while (temp != null) {
            nodeString = nodeString + temp.item + ", ";
            temp = temp.next;
        }
        if (size > 0) {
            nodeString = nodeString.substring(0, nodeString.length() - 2);
        } else if (size == 0) {
            nodeString = "[";
        }
        nodeString = nodeString + "]";
        return nodeString;
    }

    private class Node {
        public Type item;
        public Node next;

        public Node (Type item) {
            this.item = item;
            this.next = null;
        }

        public String toString() {
            return item.toString();
        }
    }
}
