import java.util.Stack;

public class validParentheses {
    public static boolean isValid(String s){
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            if(curr == '(' || curr == '{' || curr == '['){
                st.push(curr);
            } else {
                if(st.isEmpty()) return false;
                if((curr == ')' && st.peek() == '(') || (curr == '}' && st.peek() == '{') || (curr == ']' && st.peek() == '[')) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        if(st.isEmpty()) return true;
        else return false;
    }

    // Duplicate Parentheses---->
    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if(ch == ')'){
                int count = 0;
                while(s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if(count < 1) return true;
                else s.pop();
            } else {
                s.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "{([])}{}[]()";
        String str = "((a+b))";
        System.out.println(isValid(s));
        System.out.println(isDuplicate(str));
    }
}
