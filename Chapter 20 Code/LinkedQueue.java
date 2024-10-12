/**
 * This class implements a queue based
 * on linked lists.
 */

public class LinkedQueue {
    private Node front = null;
    private Node rear = null;

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();

        // Add 4 names
        String[] names =
                {"Alfonso", "Bob", "Carol", "Deborah"};
        System.out.println("Adding names: ");
        for (String s : names) {
            System.out.print(s + " ");
            queue.enqueue(s);
        }

        System.out.println("\nState of queue is: ");
        System.out.println(queue);

        // Remove 2 names
        System.out.println("Removing 2 names.");
        queue.dequeue();
        queue.dequeue();
        System.out.println("State of queue is: ");
        System.out.println(queue);

        // Add another name
        System.out.println("Adding the name Elaine:");
        queue.enqueue("Elaine");
        System.out.println("State of queue is: ");
        System.out.println(queue);
    }

    /**
     * The method enqueue adds a value
     * to the queue.
     *
     * @param s The value to be added
     *          to the queue.
     */

    public void enqueue(String s) {
        if (rear != null) {
            rear.next = new Node(s, null);
            rear = rear.next;
        }
        else {
            rear = new Node(s, null);
            front = rear;
        }
    }

    /**
     * The empty method checks to see if
     * the queue is empty.
     *
     * @return true if and only if queue
     * is empty.
     */

    public boolean empty() {
        return front == null;
    }

    /**
     * The method peek returns value at the
     * front of the queue.
     *
     * @return item at front of queue.
     * queue is empty.
     */

    public String peek() {
        if (empty()) {
            System.out.println("Error: Empty stack");
            return null;
        }
        else
            return front.value;
    }

    /**
     * The dequeue method removes and returns
     * the item at the front of the queue.
     *
     * @return item at front of queue.
     */

    public String dequeue() {
        if (empty()) {
            System.out.println("Error: Empty stack");
            return null;
        }
        else {
            String value = front.value;
            front = front.next;
            if (front == null) rear = null;
            return value;
        }
    }

    /**
     * The toString method concatenates all strings
     * in the queue to give a string representation
     * of the contents of the queue.
     *
     * @return string representation of this queue.
     */

    public String toString() {
        StringBuilder sBuilder = new StringBuilder();

        // Walk down the list and append all values
        Node p = front;
        while (p != null) {
            sBuilder.append(p.value + " ");
            p = p.next;
        }
        return sBuilder.toString();
    }

    private class Node {
        String value;
        Node next;

        Node(String val, Node n) {
            value = val;
            next = n;
        }
    }
}