import java.util.Map;
import java.util.ArrayList;

// creates a static class to hold the sortedArraySearch function, which finds the index of the
// requested integer "target" in the integer array "array" (sorted least to greatest) using a binary search algorithm
//
// sorterdArraySearch has two overloads - one for searching a String array sorted lexicographically,
// and one for searching a String array sorted according to a map (see findX.java for an example)
//
// WARNING: sorterdArraySearch does not work on unsorted arrays

public class searchFunc
{
    public static int sortedArraySearch(int[] array, int target)
    {
        int current = (array.length - 1) / 2; // the index of the value in array currently being tested
        int modifier = current / 2; // the number to add or subtract from current
        ArrayList<Integer> tested = new ArrayList<Integer>(); // list containing all values previously tested
        
        while (target != array[current])
        {
            // current is in the middle of the unchecked section of the array
            // 
            // if the current's value is greater than target, than current is too high
            // shift current to the middle of the section with lower values
            // 
            // otherwise, current is too low
            // shift current to the middle of the section with higher values

            /*
            boolean overshot = array[current] > target;
            if (overshot)
            {
                current -= modifier;
            }
            else
            {
                current += modifier;
            }
            */
            
            // more concise
            current = array[current] > target ? current - modifier : current + modifier;
            
            // modifier is halved to match current
            // if modifier is equal to 0, current never changes and an infinite loop occurs
            // keep modifier at a minimum of 1 to prevent this

            /*
            modifier /= 2;
            if (modifier < 1)
            {
                modifier = 1;
            }
            */
            
            // more concise
            modifier = Math.max(modifier / 2, 1);
            
            // if out of bounds or current has already been tested, target is not in the array 
            if (current < 0 || current >= array.length || tested.contains(current))
            {
                return -1;
            }
            
            // add current to list of tested values
            tested.add(current);
        }
        
        // array[current] == target
        return current;
    }
    
    // the same as sortedArraySearch(int[] array, int target), but uses .compareTo()
    // to determine the lexicographic position of strings
    public static int sortedArraySearch(String[] array, String target)
    {
        int current = (array.length - 1) / 2;
        int modifier = Math.max(current / 2, 1);
        ArrayList<Integer> tested = new ArrayList<Integer>();
        
        while (!target.equals(array[current]))
        {
            current = array[current].compareTo(target) > 0 ? current - modifier : current + modifier;
            
            modifier = Math.max(modifier / 2, 1);
            
            if (current < 0 || current >= array.length || tested.contains(current))
            {
                return -1;
            }
            
            tested.add(current);
        }
        
        return current;
    }

    // the same as sortedArraySearch(int[] array, int target), but uses map.get()
    // to order strings based off of their assigned integer 
    public static int sortedArraySearch(String[] array, String target, Map<String, Integer> map)
    {
        // if target has no value mapping in map, abort the search
        if (!map.containsKey(target))
        {
            return -1;
        }
        
        int current = (array.length - 1) / 2;
        int modifier = current / 2;
        ArrayList<Integer> tested = new ArrayList<Integer>();
        
        while (!target.equals(array[current]))
        {
            // if current's value has no value mapping in map, abort the search
            if (!map.containsKey(array[current]))
            {
                return -1;
            }
            
            current = map.get(array[current]) > map.get(target) ? current - modifier : current + modifier;
            
            modifier = Math.max(modifier / 2, 1);
            
            if (current < 0 || current >= array.length || tested.contains(current))
            {
                return -1;
            }
            
            tested.add(current);
        }
        
        return current;
    }
}
