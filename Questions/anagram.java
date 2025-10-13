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
    
    public static void main(String[] args) {
        String[] words = {"abba","baba","bbaa","cd","cd"};
        List<String> result = removeAnagrams2(words);
        System.out.println(result);
    }
}
