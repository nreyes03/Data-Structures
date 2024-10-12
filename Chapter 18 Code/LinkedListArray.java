import java.util.LinkedList;

public class LinkedListArray {

    public static void main(String[] args) {

        // We create a Linked List of Generic type.
        LinkedList <Integer>linkedList[] = new LinkedList[5];
        System.out.println("The Array of Linked List is: \n");
        for (int i = 0; i < 5; i++)
        {
            // Initialize each Linked List of Integer type within array
            linkedList[i] = new LinkedList<>();
            for (int j = 1; j <= 5; j++)
            {
                linkedList[i].add(i*j);
            }
            System.out.print(linkedList[i]);
            System.out.println();
        }
    }
}