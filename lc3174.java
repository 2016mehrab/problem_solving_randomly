class LC3174 {
    public String clearDigits(String s) {
       StringBuilder r = new StringBuilder();
        for (int i =0; i < s.length() ; ++i){
            if (Character.isDigit(s.charAt(i)) && r.length() !=0){
                r.setLength(r.length()-1);
            }
            else{
                r.append(s.charAt(i));
            }
        }
        return r.toString();
     
        
    }
    public static void main(String[] args) {
        LC3174 solution = new LC3174();
        
    }
}
