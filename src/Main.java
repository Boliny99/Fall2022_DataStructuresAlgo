import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<String> res = groupAnagrams(strs);
        System.out.println("Hello world!");
    }

    public static List<String> groupAnagrams (String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String key = String.valueOf(chs);
            if (!map.containsKey(key)) {
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}