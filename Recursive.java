public class Recursive
{
    public static int multiply(int x, int y)
    {
        if (y == 0)
        {
            return 0;
        } else {
            return (x + multiply(x, y - 1));
        }
    }


    public static void main(String[] args) {
        int x = 7;
        int y = 4;
        System.out.println("Product of " + x + " and " + y + " is " + multiply(x,y));
    }
}