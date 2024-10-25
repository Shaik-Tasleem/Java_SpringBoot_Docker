class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st1 = sc.next();
        String st2 = "";
        for (int i = 0; i < st1.length(); i++) {
            int count = 1;
            while (i + 1 < st1.length() && st1.charAt(i) == st1.charAt(i + 1)) {
                count++;
                i++;
            }
            st2 += st1.charAt(i) + String.valueOf(count);
        }
        if(st2.length()<=st1.length()){
            System.out.println(st2);
        }
        else{
           System.out.println(st1); 
        }
    }
}