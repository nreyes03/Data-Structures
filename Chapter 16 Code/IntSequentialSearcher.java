/**
   The IntSequentialSearcher class provides a public static
   method for performing a sequential search on an int array.
*/

public class IntSequentialSearcher
{
   /**
      The search method searches an array for a value.
      @param array The array to search.
      @param value The value to search for.
      @return The subscript of the value if found in the
              array, otherwise -1.
   */

   public static int search(int[] array, int value)
   {
      int index;        // Loop control variable
      int position;     // Position the value is found at
      boolean found;    // Flag indicating search results

      // Element 0 is the starting point of the search.
      index = 0;

      // Store the default values position and found.
      position = -1;
      found = false;

      // Search the array.
      while (!found && index < array.length)
      {
         if (array[index] == value)
         {
            found = true;
            position = index;
         }
         index++;
      }

      // Return the found element's position,
      // or -1 if not found.
      return position;
   }
}