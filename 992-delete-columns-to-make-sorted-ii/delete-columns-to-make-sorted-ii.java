class Solution {
    public int minDeletionSize(String[] strs) {
        int res =0;
        int n = strs.length;
        int len = strs[0].length();

        for(int i=0;i<len;i++){
            for(int j=1;j<n;j++){
                if (strs[j].substring(0, i).compareTo(strs[j - 1].substring(0, i)) == 0 && strs[j].charAt(i) < strs[j - 1].charAt(i)){
                    res++;

                    for(int k=0;k<n;k++){
                        StringBuilder sb = new StringBuilder(strs[k]);

                        sb.deleteCharAt(i);

                        strs[k]= sb.toString();
                    }
                    len--;
                    i--;

                    break;
                }
            }
        }
        return res;
    }
}