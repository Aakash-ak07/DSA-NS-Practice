package HeapSort;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Heap {
    // private static final Heap HeapSort = null;
    public static String frequencySort(String str)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++)
        {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        PriorityQueue<Map.Entry<Character,Integer>>maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty());
        {
            Map.Entry<Character, Integer> entry = maxHeap.poll();

            for(int i = 0; i < entry.getValue(); i++)
            {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        String str = "AakashManihar";
        System.out.print(frequencySort(str));
    }
}
