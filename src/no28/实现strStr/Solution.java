package no28.实现strStr;

//本来想写BM或者Sunday来着但是那种算法要么脱裤子放屁要么没卵用，还是KMP吧
public class Solution {
    public int[] getNext(String needle){
        int next[]=new int[needle.length()];
        int temp;
        for(int i=0;i<needle.length();i++){
            temp=i;
            if(i==0) {
                next[i]=0;
                continue;
            }
            while(temp>0){
                if(needle.charAt(i)==needle.charAt(next[temp-1])){
                    next[i]=next[temp-1]+1;break;
                }else
                    temp=next[temp-1];
            }
        }
        return next;
    }
    public int strStr(String haystack, String needle) {
        int i=0,j=0;
        int next[]=getNext(needle);
        if(needle.length()==0) return 0;
        while(i<haystack.length()&&j<needle.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                j++;i++;
            }
            else if(j>0)
                j=next[j-1];
            else i++;
        }
        if(j==needle.length()) return i-j;
        else return -1;

    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String haystack="mississippi",needle="issip";
        System.out.println(solution.strStr(haystack,needle));
    }
}


