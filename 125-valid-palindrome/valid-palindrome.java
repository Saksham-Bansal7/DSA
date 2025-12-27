class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String sec="";
        for( int i=0;i<s.length();i++){
            if ((s.charAt(i)>='a' && s.charAt(i)<='z')|| (s.charAt(i)>='0' && s.charAt(i)<='9') ){
                sec+=s.charAt(i);
            }
        }


        for( int i=0;i<sec.length()/2;i++){
            if (sec.charAt(i)!=sec.charAt(sec.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}