public class MemoryMapArray
{
    public static void main(String[] args)
    {
        int[] a = {80, 3, 72, 34, 67};
        int[] b = new int[5];
        for (int i = 0; i < b.length; i++)
        {
            b[i] = 1;
            if (a[i] < a[a.length - 1])
            {
                b[i] = a[i];
            }
        }
        a[3] = a[2] + a[1];
        for(int i=0; i<b.length; i++)
        {
            System.out.println(a[i] + b[i]);
        }
    }
}