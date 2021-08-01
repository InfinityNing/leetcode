package no14.最长公共前缀;

public class Solution {
    public int minLength(String []strs){//求最短字符串长度
        int result=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            result=strs[i].length()<result?strs[i].length():result;
        }
        return result;
    }
    public String longestCommonPrefix(String[] strs) {
        String result="";
        char temp;
        if(strs.length==0) return result;
        for(int i=0;i<minLength(strs);i++){
            temp=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i)!=temp)
                    return result;
            }
            result+=String.valueOf(temp);
        }
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String strs[]={""};
        System.out.println(solution.longestCommonPrefix(strs));
    }
}

