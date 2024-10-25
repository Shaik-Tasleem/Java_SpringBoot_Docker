public class main {
    public static boolean anagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] chcount = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            chcount[str1.charAt(i)]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            chcount[str2.charAt(i)]--;
        }
        for (int count : chcount) {
            if (count != 0) {
                return false; 
            }
        }
        return true; 
    public static void main(String[] args) {
        System.out.println(areAnagrams("listen", "silent")); 
    }
}


