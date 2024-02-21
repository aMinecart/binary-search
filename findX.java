import java.util.Map;
import static java.util.Map.entry;

public class findX
{
    private static Map<String, String> letToNumMap = Map.ofEntries
        (
            entry("a", "1"),
            entry("b", "2"),
            entry("c", "3"),
            entry("d", "4"),
            entry("e", "5"),
            entry("f", "6"),
            entry("g", "7"),
            entry("h", "8"),
            entry("i", "9"),
            entry("j", "10"),
            entry("k", "11"),
            entry("l", "12"),
            entry("m", "13"),
            entry("n", "14"),
            entry("o", "15"),
            entry("p", "16"),
            entry("q", "17"),
            entry("r", "18"),
            entry("s", "19"),
            entry("t", "20"),
            entry("u", "21"),
            entry("v", "22"),
            entry("w", "23"),
            entry("x", "24"),
            entry("y", "25"),
            entry("z", "26")
        );
    
    public static void main(String[] args)
    {
        String find = "x";
        String[] arr = {"a", "b", "c", "x", "y"};
        
        String test = "catalytic";
        String[] array = {"cat", "catastrophe", "cattle", "catz"};
        
        int num = 1;
        int[] arguments = {1, 2, 3, 4, 7, 9};
        
        int varPos = searchFunc.sortedArraySearch(arr, find, letToNumMap);
        System.out.println("The variable 'find' is position " + varPos + " of our array.");
        
        int stringPos = searchFunc.sortedArraySearch(array, test);
        System.out.println("The string 'test' is position " + stringPos + " of our array.");
        
        int numPos = searchFunc.sortedArraySearch(arguments, num);
        System.out.println("The integer 'num' is position " + numPos + " of our array.");
    }
}