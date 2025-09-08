
public class Uppercase {
    public static void main(String[] args) {
        String str = "hi, i am a java developer";
    
        System.out.println(toUpperCase(str)); // Converts the entire string to uppercase
        // or simply use str.toUpperCase() to convert the entire string to uppercase

        System.out.println(lengthOfLastWord(str));
    }

    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                i++;
                
                ch = Character.toUpperCase(str.charAt(i));
                sb.append(ch);
    
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static int lengthOfLastWord(String str) {
        int length = 0;
        for(int i=str.length()-1; i>=0; i--){
            if(str.charAt(i) != ' '){
                length++;
            } else {
                if(length > 0){
                    return length;
                }
            }
        }
        return length;
    }
}
