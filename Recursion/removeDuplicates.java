public class removeDuplicates {
    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean[] map){
        // Base case
        if (idx == str.length()){
            System.out.println(newStr);
            return;
        }
        // Recursive case
        char currChar = str.charAt(idx);
        if(map[currChar - 'a'] == true){
            // duplicate
            removeDuplicates(str, idx+1, newStr, map);
        } else {
            // not duplicate
            map[currChar - 'a'] = true;
            newStr.append(currChar);
            removeDuplicates( str, idx+1, newStr, map); 
        }
    }

    public static void main(String[] args) {
        String str = "aabbccdd";
        removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
        // The boolean array is used to track which characters have been seen.
    }
}
