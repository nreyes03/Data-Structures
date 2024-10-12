public class TwoDArray
{
    public static void main(String[] args)
    {
        int[][] arr = {{56,65,99,65,45}, {88,78,15,36,5}, {7,98,2,105,55}, {89,32,12,4,58}};
        System.out.println("Total: " + getTotal(arr));
        System.out.println("Average " + getAverage(arr));
        System.out.println("Row Total: " + getRowTotal(arr, 1));
        System.out.println("Column Total: " + getColumnTotal(arr, 1));
        System.out.println("Highest In Row: " + getHighestInRow(arr, 1));
        System.out.println("Lowest In Row: " + getLowestInRow(arr, 1));
    }

    public static int getTotal(int[][] arr)
    {
        int total = 0;
        for(int row = 0; row < arr.length; row++)
        {
            for (int col = 0; col < arr[row].length; col++)
            {
                total += arr[row][col];
            }
        }
        return total;
    }

    public static double getAverage(int[][] arr)
    {
        int total = getTotal(arr);
        double count = arr.length * arr[0].length;
        return total / count;
    }

    public static int getRowTotal(int[][] arr, int row)
    {
        int total = 0;
        for(int col = 0; col < arr[row].length; col++)
        {
            total += arr[row][col];
        }
        return total;
    }

    public static int getColumnTotal(int[][] arr, int col)
    {
        int total = 0;
        for(int row = 0; row < arr.length; row++)
        {
            total += arr[row][col];
        }
        return total;
    }

    public static int getHighestInRow(int[][] arr, int row)
    {
        int highest = arr[row][0];
        for(int col = 1; col < arr[row].length; col++)
        {
            if(arr[row][col] > highest)
            {
                highest = arr[row][col];
            }
        }
        return highest;
    }

    public static int getLowestInRow(int[][] arr, int row)
    {
        int lowest = arr[row][0];
        for(int col = 1; col < arr[row].length; col++)
        {
            if(arr[row][col] < lowest)
            {
                lowest = arr[row][col];
            }
        }
        return lowest;
    }
}