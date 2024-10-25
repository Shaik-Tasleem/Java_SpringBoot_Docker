class pal {
    public static boolean ispal(String input){
        StringBuilder b=new StringBuilder();
        for(char c:input.toCharArray()){
            if(Character.isLetter(c)){
                b.append(Character.toLowerCase(c));
            }
        }
        String s1=b.toString();
        String  rev=b.reverse().toString();
        return rev.equals(s1);
    }
    public static void main(String[] args) {
        String input="A mana,plan,a canalPanama";
        System.out.println(ispal(input));
    }
}
