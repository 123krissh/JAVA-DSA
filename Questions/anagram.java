import java.util.*;

public class anagram {
    
    public static List<String> removeAnagrams1(String[] words) {
        List<String> list = new ArrayList<>(Arrays.asList(words));
        for(int i=1; i<words.length; i++){
            if(isAnagram(words[i-1], words[i])){
                list.remove(words[i]);
            }
        }
        return list;
    }

    public static boolean isAnagram(String s1, String s2) {
        if(s1.length() == s2.length()) {
            char[] s1charArr = s1.toCharArray();
            char[] s2charArr = s2.toCharArray();

            Arrays.sort(s1charArr);
            Arrays.sort(s2charArr);

            boolean result = Arrays.equals(s1charArr, s2charArr);
            return result;
        }
        else {
            return false;
        }
    }
    // OR
    public static String sortString(String s){
        char[] strArr = s.toCharArray();
        Arrays.sort(strArr);
        return new String(strArr);
    }
    public static List<String> removeAnagrams2(String[] words) {
        String prev = "";
        List<String> list = new ArrayList<>();
        for(int i=0; i<words.length; i++){
            String str = sortString(words[i]);
            if(!str.equals(prev)){
                prev = str;
                list.add(words[i]);
            }
        }
        return list;
    }  
    
    // Group Anagrams ---->
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    // public static List<List<String>> groupAnagrams(String[] strs) {
    //     Map<Integer, List<String>> map = new HashMap<>();
    //     boolean[] visited = new boolean[strs.length];
    //     List<List<String>> ans = new ArrayList<>();
        
    //     for (int i = 0; i < strs.length; i++) {
    //         if (visited[i]) continue; 

    //         List<String> group = new ArrayList<>();
    //         group.add(strs[i]);
    //         visited[i] = true;

    //         for (int j = i + 1; j < strs.length; j++) {
    //             if (!visited[j] && isAnagram(strs[i], strs[j])) {
    //                 group.add(strs[j]);
    //                 visited[j] = true;
    //             }
    //         }
    //         map.put(i, group);
    //     }
    //     for (List<String> list : map.values()) {
    //         ans.add(new ArrayList<>(list));
    //     }
    //     return ans;
    // }
    
    public static void main(String[] args) {
        String[] words = {"abba","baba","bbaa","cd","cd"};
        List<String> result = removeAnagrams2(words);
        System.out.println(result);

        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> grpAnagrams = groupAnagrams(strs);
        System.out.println(grpAnagrams);
    }
}
