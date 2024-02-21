import java.util.Map;
import static java.util.Map.entry;

// test class for searchFunc
public class findX
{
    // example string to integer mapping. "a", "b", etc. can be replaced with any string.
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
    
    public static void main(String[] args)
    {
        int num = 1;
        int[] arguments = {1, 2, 3, 4, 7, 9};
        
        String test = "catalytic";
        String[] arr = {"cat", "catastrophe", "cattle", "catz"};
        
        String find = "x";
        String[] array = {"a", "b", "c", "x", "y"};

        int numPos = searchFunc.sortedArraySearch(arguments, num);
        System.out.println("The integer 'num' is position " + numPos + " of the array 'arguments'.");
        
        int stringPos = searchFunc.sortedArraySearch(arr, test);
        System.out.println("The string 'test' is position " + stringPos + " of the array 'arr'.");
        
        int varPos = searchFunc.sortedArraySearch(array, find, letToNumMap);
        System.out.println("The variable 'find' is position " + varPos + " of the array 'array'.");
    }
}
