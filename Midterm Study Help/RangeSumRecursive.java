/**
   This program demonstrates the recursive rangeSum method.
*/

public class RangeSumRecursive
{

   public static void main(String[] args)
   {
      int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      
      System.out.print("The sum of all the elements is "
                       + rangeSum(numbers, 0, numbers.length-1));
   }
   
   /**
      The rangeSum method calculates the sum of a specified
      range of elements in array. 
      @param start Specifies the starting element.
      @param end Specifies the ending element.
      @return The sum of the range.
   */
   
   public static int rangeSum(int[] array, int start, int end)
   {
      if (start > end)
         return 0;
      else
         return array[start] + rangeSum(array, start + 1, end);
   }
}
