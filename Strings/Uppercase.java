
public class Uppercase {
    public static void main(String[] args) {
        String str = "hi, i am a java developer";
    
        System.out.println(toUpperCase(str)); // Converts the entire string to uppercase
        // or simply use str.toUpperCase() to convert the entire string to uppercase
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
}
