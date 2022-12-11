import java.util.*;

public class Main {
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
            if (!map.containsKey(ch.toString())) {
                map.put(ch.toString(),new ArrayList<>());
            }
            List<String> val = map.get(ch.toString());
            val.add(str);
            map.put(ch.toString(),val);
        }
        res = new ArrayList<>(map.values());
        return res;

    }
}