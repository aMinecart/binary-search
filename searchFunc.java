import java.util.Map;
import java.util.ArrayList;

/*
creates a class to hold the static function sortedArraySearch, which finds the index of the
number "target" in the array of the same subtype "array" using a binary search algorithm

sorterdArraySearch has overloads for:
- searching an int array sorted numerically
- searching a float array sorted numerically
- searching a double array sorted numerically
- searching a long array sorted numerically
- searching a String array sorted lexicographically
- searching a generic array extending Comparable using compareTo()
- searching a generic array sorted according to a map

see findX.java for examples

WARNING: arrays inputted into sortedArraySearch must be sorted from least to greatest
*/

public class searchFunc
{
    public static int sortedArraySearch(int[] array, int target)
    {
        int current = (array.length - 1) / 2; // the index of the value in array currently being tested
        int modifier = current / 2; // the number to add or subtract from current
        ArrayList<Integer> tested = new ArrayList<Integer>(); // list containing all values previously tested
        
        while (target != array[current])
        {
            /*
            current is in the middle of the unchecked section of the array
            
            if the array[current]'s value is greater than target, than current is too high
            shift current to the middle of the section with lower values
            
            otherwise, current is too low
            shift current to the middle of the section with higher values
            */

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
            
            /*
            modifier is halved to match current
            if modifier is equal to 0, current never changes and an infinite loop occurs
            keep modifier at a minimum of 1 to prevent this
            */
            
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
            
            // add current to list of tested indices
            tested.add(current);
        }
        
        // array[current] == target
        return current;
    }

    // overload of sortedArraySearch(int[] array, int target) for floats
    public static int sortedArraySearch(float[] array, float target)
    {
        int current = (array.length - 1) / 2; // the index of the value in array currently being tested
        int modifier = current / 2; // the number to add or subtract from current
        ArrayList<Integer> tested = new ArrayList<Integer>(); // list containing all values previously tested
        
        while (target != array[current])
        {
            current = array[current] > target ? current - modifier : current + modifier;
            
            modifier = Math.max(modifier / 2, 1);
            
            if (current < 0 || current >= array.length || tested.contains(current))
            {
                return -1;
            }
            
            tested.add(current);
        }
        
        return current;
    }

    // overload of sortedArraySearch(int[] array, int target) for doubles
    public static int sortedArraySearch(double[] array, double target)
    {
        int current = (array.length - 1) / 2; // the index of the value in array currently being tested
        int modifier = current / 2; // the number to add or subtract from current
        ArrayList<Integer> tested = new ArrayList<Integer>(); // list containing all values previously tested
        
        while (target != array[current])
        {
            current = array[current] > target ? current - modifier : current + modifier;
            
            modifier = Math.max(modifier / 2, 1);
            
            if (current < 0 || current >= array.length || tested.contains(current))
            {
                return -1;
            }
            
            tested.add(current);
        }
        
        return current;
    }

    // overload of sortedArraySearch(int[] array, int target) for longs
    public static int sortedArraySearch(long[] array, long target)
    {
        int current = (array.length - 1) / 2; // the index of the value in array currently being tested
        int modifier = current / 2; // the number to add or subtract from current
        ArrayList<Integer> tested = new ArrayList<Integer>(); // list containing all values previously tested
        
        while (target != array[current])
        {
            current = array[current] > target ? current - modifier : current + modifier;
            
            modifier = Math.max(modifier / 2, 1);
            
            if (current < 0 || current >= array.length || tested.contains(current))
            {
                return -1;
            }
            
            tested.add(current);
        }
        
        return current;
    }
    
    // works similarly to sortedArraySearch(int[] array, int target), but searches an arrray of
    // strings using compareTo() to lexicographically determine their position
    public static int sortedArraySearch(String[] array, String target)
    {
        int current = (array.length - 1) / 2;
        int modifier = Math.max(current / 2, 1);
        ArrayList<Integer> tested = new ArrayList<>();
        
        while (!target.equals(array[current]))
        {
            // if the boolean expression evaluates to true, array[current] comes after target
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

    // works similarly to sortedArraySearch(String[] array, String target), allowing for any array of 
    // a Comparable class to be searched using compareTo()
    public static <T extends Comparable<T>> int sortedArraySearch(T[] array, T target)
    {
        int current = (array.length - 1) / 2;
        int modifier = current / 2;
        ArrayList<Integer> tested = new ArrayList<>();
        
        // use compareTo() to safely check for equality between target and array[current]
        while (target.compareTo(array[current]) != 0)
        {
            // if the boolean expression evaluates to true, array[current] comes after target
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

    /*
    based off of sortedArraySearch(int[] array, int target), but uses map.get()
    to search any array of objects based off of their assigned integer in map
    
    Note: array must be sorted least-to-greatest based on map's order in order to produce correct results
    (in other words, the integer mapped to any element of array must be less than the integers 
    mapped to any following elements)
    */
    public static <T> int sortedArraySearch(T[] array, T target, Map<T, Integer> map)
    {
        // if target has no value mapping in map, abort the search
        if (!map.containsKey(target))
        {
            return -1;
        }
        
        int current = (array.length - 1) / 2;
        int modifier = current / 2;
        ArrayList<Integer> tested = new ArrayList<>();
        
        while (!target.equals(array[current]))
        {
            // if array[current]'s value has no value mapping in map, abort the search
            if (!map.containsKey(array[current]))
            {
                return -1;
            }
            
            // if array[current]'s value in map is greater than target's value, array[current] comes after target
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
