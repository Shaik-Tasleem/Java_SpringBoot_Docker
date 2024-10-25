class sub {
    public static int lonsubarr(String input){
        int max=0;
        int start=0;
        HashSet<Character>set=new HashSet<>();
        for(int end=0;end<input.length();end++){
            char c=input.charAt(end);
            while(set.contains(c)){
                set.remove(input.charAt(start));
                start++;
            }
            set.add(c);
            max=Math.max(max,set.size());
        }
        return max;
    }
    public static void main(String[] args) {
        String input="abcabcbb";
        System.out.println(lonsubarr(input));
    }
}
