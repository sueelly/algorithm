import java.util.*;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        List<Integer> values = new ArrayList<>(map.values());
        int count = 0, size = values.size();

        Collections.sort(values);
        for (Integer v : values) { // 0으로 만들 수 있는 개수 count
            if ((k -= v) < 0) break ;
            count++; 
        }
        return size - count;
    }
}