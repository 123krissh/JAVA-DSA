public class sbDemo {
    public static void main(String[] args) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for(char ch='a'; ch<='z'; ch++) {
            sb.append(ch);
        }
        System.out.println(sb);
        System.out.println(sb.length());
    }
}
