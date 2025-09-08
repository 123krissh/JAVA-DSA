import java.util.LinkedList;
import java.util.Queue;

public class firstNonRepeating {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println(firstNonRepeating(str));
        printNonRepeating(str);
    }

    public static char firstNonRepeating(String str) {
        int[] freq = new int[256];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }
        return '\0';
    }

    // First non-repeating letters in a stream of characters
    public static void printNonRepeating(String str){
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;

            while (!q.isEmpty() && freq[q.peek() -'a'] > 1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.print(-1+" ");
            } else {
                System.out.print(q.peek()+ " ");
            }
        }
        System.out.println();
    }
}
