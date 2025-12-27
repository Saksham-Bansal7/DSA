class Solution {
      public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sec =new StringBuilder();
        for( int i=0;i<s.length();i++){
            if ((s.charAt(i)>='a' && s.charAt(i)<='z')|| (s.charAt(i)>='0' && s.charAt(i)<='9') ){
                sec.append(s.charAt(i));
            }
        }
        String sec2 = sec.toString();
        return sec.reverse().toString().equals(sec2);
    }
}