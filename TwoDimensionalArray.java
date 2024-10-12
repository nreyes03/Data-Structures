public class TwoDimensionalArray
{
    public static void main(String[] args)
    {
        int[][] numbers = {{1, 2, 3, 4, 5},
                           {6, 7, 8, 9, 10},
                           {1, 2, 3, 4, 15},
                           {4, 7, 4, 4, 7},
                           {6, 3, 7, 12, 4}};
        int total = sum_numbers(numbers);

        System.out.println("The sum of all numbers is " + total);
    }

    public static int sum_numbers(int[][] array)
    {
        int total = 0;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++)
                total += array[i][j];
        return total;
    }
}



