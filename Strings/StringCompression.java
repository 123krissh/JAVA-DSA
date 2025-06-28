public class StringCompression {
     public static void main(String[] args) {
         String str = "aaabbccdeee";
         System.out.println(compressString(str));
     }
     public static String compressString(String str) {
        StringBuilder sb = new StringBuilder("");
        if (str == null || str.length() == 0) {
            return str; // return empty string if input is null or empty
        }
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                sb.append(str.charAt(i - 1));
                if (count > 1) {
                    sb.append(count);
                }
                count = 1; // reset count for the next character
            }
        }
        // Handle the last character
        sb.append(str.charAt(str.length() - 1));
        if (count > 1) {
            sb.append(count);
        }
        return sb.toString();
     }
}
