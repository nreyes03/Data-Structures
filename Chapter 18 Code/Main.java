import java.util.*;

public class Main {
    static int hashCode(String name) {
        int hash = 0;
        for (int i=0; i<name.length(); i++) {
            hash += name.charAt(i);
        }
        hash = Math.abs(hash);
        hash %= 10;
        System.out.println(name + " : Hash: " + hash);
        return hash;
    }

    public static void main(String[] args) {
        // Iterator example
        List<String> names = new ArrayList<>();
        names.add("Anna");
        names.add("Bob");
        names.add("Carlos");

        System.out.println(names);   // prints: [Anna, Bob, Carlos]
        Iterator<String>  it = names.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println(names);
// *************************************************************************
//        String name;
//        int hash;
//        name = "this";
//        hash = hashCode(name);
//        System.out.println(hash);
// *************************************************************************
//        // A more sophisticated string hash
//        String key = "this";
//        int hash = 0;
//        for (int i=0; i<key.length(); i++)
//            hash += key.charAt(i) * Math.pow(2, i);
//        System.out.println(hash);
    }
}



// *************************************************************************
//        printArray(names);
//
//        Scanner keyboard = new Scanner(System.in);
//        System.out.print("Enter name: ");
//        name = keyboard.nextLine();
//        while (!name.equals("")) {
//            hash = hashCode(name);
//            if (name.equals(names[hash]))
//                System.out.println("The name " + name + " is in the array.");
//            else
//                System.out.println("The name " + name + " is not in the array.");
//            System.out.print("Enter name: ");
//            name = keyboard.nextLine();
//        }
//    }
//}
