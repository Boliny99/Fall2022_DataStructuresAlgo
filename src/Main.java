import java.util.*;

public class Main {

    //Time comlexity : O(n)
    //Space complexity: O(n)
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res = groupAnagrams(strs);

        System.out.println("Hello world!");
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if (!map.containsKey(key)) {
                map.put(key,new ArrayList<>());
            }
            List<String> val = map.get(key);
            val.add(str);
            map.put(key,val);
        }
        res = new ArrayList<>(map.values());
        return res;

    }
}