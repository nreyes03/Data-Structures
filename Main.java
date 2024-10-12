class BankAccount  //BankAccount Class
{
    private final String name; //Account Name Field
    private final double balance; //Account Balance Field

    /**
     This constructor accepts the name and balance to populate fields during object creation.
     @param name The name of account.
     @param balance The account balance.
     */
    public BankAccount(String name, double balance)
    {
        this.name = name;
        this.balance = balance;
    }

    /**
     The getName method returns the
     account name.
     @return The value in the name field.
     */
    public String getName()
    {
        return name;
    }

    /**
     The getBalance method returns the
     account balance.
     @return The value in the balance field.
     */
    public double getBalance()
    {
        return balance;
    }
}

/**
 The Node class stores a data member variable
 and a reference to the next node.
 */
class Node //Node Class
{
    public BankAccount data; //Data Member Variable
    public Node next; //Next Node In The List
    public Node prev; //Previous Node In The List

    /**
     Constructor.
     */
    public Node(BankAccount data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

/**
 The DoublyLinkedList class implements a doubly
 Linked list.
 */
 class DoublyLinkedList //DoublyLinkedList Class
{
    private Node head; //Head Of The List
    private Node tail; //Tail Of The List
    private int size; //Size Of The List

    /**
     Constructor.
     */
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     The addHead method adds a node containing a Bank account object to the head of the list.
     @param name The value to add.
     @param balance The value to add.
     */
    public void addHead(String name, double balance) {
        BankAccount account = new BankAccount(name, balance);
        Node newNode = new Node(account);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    /**
     The addTail method adds a node containing a Bank account object to the end of the list.
     @param name The value to add.
     @param balance The value to add.
     */
    public void addTail(String name, double balance) {
        BankAccount account = new BankAccount(name, balance);
        Node newNode = new Node(account);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    /**
     The insertAt method inserts at nth element a Bank account object.
     @param name The value to insert.
     @param balance The value to insert.
     @exception IndexOutOfBoundsException
     When the index is out of bounds.
     */
    public void insertAt(int n, String name, double balance) {
        if (n < 0 || n > size) {
            throw new IndexOutOfBoundsException();
        }

        if (n == 0) {
            addHead(name, balance);
        } else if (n == size) {
            addTail(name, balance);
        } else {
            BankAccount account = new BankAccount(name, balance);
            Node newNode = new Node(account);

            Node current = head;
            for (int i = 0; i < n; i++) {
                current = current.next;
            }

            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;

            size++;
        }
    }

    /**
     The size method returns the length of the list.
     @return The number of elements in the list.
     */
    public int size() {
        return size;
    }

    /**
     The boolean isFound method returns whether an account
     with given name exists in the double linked list.
     @return true if name is found, false otherwise.
     */
    public boolean isFound(String name) {
        Node current = head;
        while (current != null) {
            if (current.data.getName().equals(name)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     The countGreaterOrEqualTo method returns the number
     of times a balance is greater than or equal to amount.
     @return count.
     */
    public int countGreaterOrEqualTo(double amount) {
        int count = 0;
        Node current = head;
        while (current != null) {
            if (current.data.getBalance() >= amount) {
                count++;
            }
            current = current.next;
        }
        return count;
    }

    /**
     The removeAll method removes all elements in the list.
     @return The elements removed.
     */
    public void removeAll() {
        head = null;
        tail = null;
        size = 0;
    }


    /**
     The removeHead method removes the node at the
     head of the list and returns the element.
     @return The name removed.
     */
    public String removeHead() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }

        String name = head.data.getName();

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        size--;
        return name;
    }

    /**
     The removeTail method removes the element at the
     tail of the list and returns the element.
     @return The element removed.
     */
     public String removeTail() {
         if (tail == null) {
             throw new RuntimeException("List is empty");
         }

         String name = tail.data.getName();

         if (head == tail) {
             head = null;
             tail = null;
         } else {
             tail = tail.prev;
             tail.next = null;
         }

         size--;
         return name;
     }

    /**
     The removeElement method removes the element at a given position.
     @param x The position of the element to remove.
     @return The element removed.
     @exception IndexOutOfBoundsException
     When index is out of bounds.
     */
     public String removeElement(int x)
     {
         if(x < 0 || x >= size())
         {
             throw new IndexOutOfBoundsException();
         }
         if(x == 0)
         {
             return removeHead();
         } else if (x == size -1 )
         {
             return removeTail();
         }else
         {
             Node current = head;
             for(int i = 0; i<x; i++)
             {
                 current = current.next;
             }
             String name = current.data.getName();
             current.prev.next = current.next;
             current.next.prev = current.prev;
             size--;
             return name;
         }
     }
}


public class Main
{
    public static void main(String[] args)
    {
        DoublyLinkedList list = new DoublyLinkedList();
        // test addHead and size on empty list
        System.out.println(list.size()); // 0
        list.addHead("John", 100.0);
        System.out.println(list.size()); // 1

        // test addTail
        list.addTail("Jane", 200.0);
        System.out.println(list.size()); // 2

        // test insertAt
        list.insertAt(1, "Bob", 50.0);
        System.out.println(list.size()); // 3

        // test isFound
        System.out.println(list.isFound("John")); // true
        System.out.println(list.isFound("Mary")); // false

        // test countGreaterOrEqualTo
        System.out.println(list.countGreaterOrEqualTo(100.0)); // 2

        // test removeHead
        System.out.println(list.removeHead()); // John
        System.out.println(list.size()); // 2

        // test removeTail
        System.out.println(list.removeTail()); // Jane
        System.out.println(list.size()); // 1

        // test removeElement
        System.out.println(list.removeElement(0)); // Bob
        System.out.println(list.size()); // 0

        // test removeAll
        list.addHead("John", 100.0);
        list.addHead("Jane", 200.0);
        System.out.println(list.size()); // 2
        list.removeAll();
        System.out.println(list.size()); // 0
    }
}