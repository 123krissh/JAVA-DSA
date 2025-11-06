import java.util.List;

public class trie {
    // Trie also called a prefix tree, Retrieval tree,
    //  is a special tree-based data structure used to store and search strings efficiently — especially useful when dealing with:
    // ✅ Auto-complete
    // ✅ Searching words in a dictionary
    // ✅ Unique prefix finding
    // ✅ Spell checking
    // ✅ Prefix matching  etc....

    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        int freq; // frequency of words ending at this node this is for prefix problem

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) { //O(L)
        Node curr = root;
        for(int level=0; level<word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } else { // for prefix problem
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String key) { //O(L)
        Node curr = root;
        for(int level=0; level<key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    // word break problem O(L)
    public static boolean wordBreak(String key) { 
        if(key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            if (search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }
    // OR dp approach leetcode
    static Boolean[] dp;
    public static boolean wordBreak(String s, List<String> wordDict) {
        root = new Node();
        for(int i=0; i<wordDict.size(); i++){
            insert(wordDict.get(i));
        }
        dp = new Boolean[s.length() + 1]; 
        return wordBreakSolve(s, 0);
    }
    public static boolean wordBreakSolve(String s, int start) {
        if(start == s.length()) return true;
        if(dp[start] != null) return dp[start];
        Node curr = root;
        for(int end = start; end < s.length(); end++) {
            int idx = s.charAt(end) - 'a';
            if(curr.children[idx] == null) break;
            curr = curr.children[idx];

            if(curr.eow && wordBreakSolve(s, end + 1)) {
                return dp[start] = true;
            }
        }
        return dp[start] = false;
    }

    // prefix problem
    public static String[] uniquePrefix(String arr[]) {
        int n = arr.length;
        String res[] = new String[n];
        for(int i=0; i<n; i++) {
            Node curr = root;
            String word = arr[i];
            for(int level=0; level<word.length(); level++) {
                int idx = word.charAt(level) - 'a';
                curr = curr.children[idx];

                if (curr.freq == 1) {
                    res[i] = word.substring(0, level+1);
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String words[] = { "the", "a", "there", "their", "any", "thee"};
        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }  
        System.out.println(search("thee"));
        System.out.println(search("thor"));

        String key = "thereanythee";
        System.out.println(wordBreak(key));

        String arr[] = {"zebra", "dog", "dove", "duck"};
        for(int i=0; i<arr.length; i++){
            insert(arr[i]);
        } 
        String res[] = uniquePrefix(arr);
        for(String s : res) {
            System.out.print(s + " ");
        }
    }
}
