public class main {
    public static char firstnonrep(String str) {
        int[] charCount = new int[256]; 
        for (int i = 0; i < str.length(); i++) {
            charCount[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (charCount[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }
        return '-';
    }
    public static void main(String[] args) {
        System.out.println(firstnonrep("swiss"));
    }
}
