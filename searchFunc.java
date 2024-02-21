import java.util.Map;
import java.util.ArrayList;

public class searchFunc
{
    public static int sortedArraySearch(String[] array, String target, Map<String, Integer> map)
    {
        int current = (array.length - 1) / 2;
        int modifier = current / 2;
        ArrayList<Integer> tested = new ArrayList<Integer>();
        
        while (!target.equals(array[current]))
        {
            boolean overshot = map.get(array[current]) > map.get(target);
            if (overshot)
            {
                current -= modifier;
            }
            else
            {
                current += modifier;
            }
                
            /*
            modifier /= 2;
            if (modifier < 1)
            {
                modifier = 1;
            }
            */
            
            modifier = Math.max(modifier / 2, 1);
            
            
            if (current < 0 || current >= array.length || tested.contains(current))
            {
                return -1;
            }
            
            tested.add(current);
        }
        
        return current;
    }
    
    public static int sortedArraySearch(String[] array, String target)
    {
        int current = (array.length - 1) / 2;
        int modifier = Math.max(current / 2, 1);
        ArrayList<Integer> tested = new ArrayList<Integer>();
        
        while (!target.equals(array[current]))
        {
            boolean overshot = array[current].compareTo(target) > 0;
            
            if (overshot)
            {
                current -= modifier;
            }
            else
            {
                current += modifier;
            }
                
            modifier = Math.max(modifier / 2, 1);
            
            if (current < 0 || current >= array.length || tested.contains(current))
            {
                return -1;
            }
            
            tested.add(current);
        }
        
        return current;
    }
    
    public static int sortedArraySearch(int[] array, int target)
    {
        int current = (array.length - 1) / 2;
        int modifier = current / 2;
        ArrayList<Integer> tested = new ArrayList<Integer>();
        
        while (target != array[current])
        {
            boolean overshot = array[current] > target;
            if (overshot)
            {
                current -= modifier;
            }
            else
            {
                current += modifier;
            }
            
            // current = array[current] > target ? current - modifier : current + modifier;
            
            /*
            modifier /= 2;
            if (modifier < 1)
            {
                modifier = 1;
            }
            */
            
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