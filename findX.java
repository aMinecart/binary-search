import java.util.Map;
import static java.util.Map.entry;

// test class for searchFunc
public class findX
{
    // example mapping of String values to int (autoboxed to Integer) values.
    // "a", "b", etc. can be replaced with any object, as long as all entries have the same type.
    // in this example, "a" will be treated as the lowest value, followed by "b", then "c", etc.
    private static Map<String, Integer> letToNumMap = Map.ofEntries
        (
            entry("a", 1),
            entry("b", 2),
            entry("c", 3),
            entry("d", 4),
            entry("e", 5),
            entry("f", 6),
            entry("g", 7),
            entry("h", 8),
            entry("i", 9),
            entry("j", 10),
            entry("k", 11),
            entry("l", 12),
            entry("m", 13),
            entry("n", 14),
            entry("o", 15),
            entry("p", 16),
            entry("q", 17),
            entry("r", 18),
            entry("s", 19),
            entry("t", 20),
            entry("u", 21),
            entry("v", 22),
            entry("w", 23),
            entry("x", 24),
            entry("y", 25),
            entry("z", 26)
        );
    
    // identical to letToNumMap, but with "a" as the highest value, "b" as the second lowest, etc.
    private static Map<String, Integer> reverseLetToNumMap = Map.ofEntries
        (
            entry("a", 26),
            entry("b", 25),
            entry("c", 24),
            entry("d", 23),
            entry("e", 22),
            entry("f", 21),
            entry("g", 20),
            entry("h", 19),
            entry("i", 18),
            entry("j", 17),
            entry("k", 16),
            entry("l", 15),
            entry("m", 14),
            entry("n", 13),
            entry("o", 12),
            entry("p", 11),
            entry("q", 10),
            entry("r", 9),
            entry("s", 8),
            entry("t", 7),
            entry("u", 6),
            entry("v", 5),
            entry("w", 4),
            entry("x", 3),
            entry("y", 2),
            entry("z", 1)
        );
    
    public static void main(String[] args)
    {
        int num = 1;
        int[] arguments = {1, 2, 3, 4, 7, 9};
        
        int numPos = searchFunc.sortedArraySearch(arguments, num);
        System.out.println("The integer 'num' is position " + numPos + " of the array 'arguments'.");

        
        String test = "catalytic";
        String[] arr = {"cat", "catastrophe", "cattle", "catz"};
        
        int stringPos = searchFunc.sortedArraySearch(arr, test);
        System.out.println("\nThe string 'test' is position " + stringPos + " of the array 'arr'.");

        
        String find = "x";
        String[] array = {"a", "b", "c", "x", "y"};
        String[] reverseArray = {"y", "x", "c", "b", "a"};

        int varPos = searchFunc.sortedArraySearch(array, find, letToNumMap);
        System.out.println("\nThe variable 'find' is position " + varPos + " of the array 'array'.");
        
        // since the a is the 'highest' value in reverseLetToNumMap, our array has to be reversed 
        // to still be sorted least-to-greatest
        varPos = searchFunc.sortedArraySearch(reverseArray, find, reverseLetToNumMap);
        System.out.println("The variable 'find' is position " + varPos + " of the array 'reverseArray'.");
    }
}
