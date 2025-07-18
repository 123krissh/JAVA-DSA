public class stringOperation {
    public static char processString(String s, long k){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (Character.isLowerCase(curr)) {
                result.append(curr);
            }
            else if(curr == '*'){
                if (!result.isEmpty()) {
                    result.deleteCharAt(result.length() - 1);
                }
            }
            else if(curr == '#'){
                result.append(result);
            }
            else if(curr == '%') {
                result.reverse();
            }
        }
        return k < result.length() ? result.charAt((int)k) : '.';
    }

    public static void main(String[] args) {
        System.out.println(processString("a#b%*", 1));     // Output: a
        System.out.println(processString("cd%#*#", 3));    // Output: d
        System.out.println(processString("z*#", 0));       // Output: .
        System.out.println(processString("rl#r%#e##%t##%#*####a%#h#%ej#rjme#%e#####g%s#%%ojm", 1225)); // Output: r
    }
}
