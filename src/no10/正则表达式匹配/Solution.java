package no10.正则表达式匹配;
/*
动态规划表格
    &   c   *   a   *   b
&   T   F   T   F   T   F
a   F   F   F   T   T   F
a   F   F   F   F   T   F
b   F   F   F   F   F   T
规则  遇到相同字母，检查左上角，若为T(说明该字母之前匹配成功)，则该处为T，若为F，则该处为F
     遇到不同字母，直接为F
     遇到*，首先检查该行左移两个，若为T(说明没有这个c*也匹配成功，该c*可跳过)，则该处为T
           若为F，则检查该*的前一个字母c是否和字符串中该字母相同，若相同【且上移一个为T】(说明a*可表示多个a)则该处为T，否则为F
*/

public class Solution {
    public boolean isMatch(String s, String p) {
        boolean dp[][]=new boolean[s.length()+1][p.length()+1];
        for(int i=0;i<s.length()+1;i++){
            for(int j=0;j<p.length()+1;j++){
                if(i==0&&j==0) dp[i][j]=true;//初始化(0,0)
                else if(j==0) dp[i][j]=false;//初始化第一列
                else if(p.charAt(j-1)>=97&&p.charAt(j-1)<=122||p.charAt(j-1)=='.'){//表达式为字母或.
                    if(i==0) dp[i][j]=false;//第一行为字母直接为F
                    else dp[i][j]=dp[i-1][j-1]//字母相同且左上角为T则为T
                            &&(p.charAt(j-1)==s.charAt(i-1)||p.charAt(j-1)=='.')?true:false;
                }
                else {//表达式为*
                    if(dp[i][j-2]) dp[i][j]=true;//左移两个为T直接T
                    else{//左移两个为F
                        if(i==0) {
                            dp[i][j]=false;
                            continue;
                        }
                        dp[i][j]=(p.charAt(j-2)==s.charAt(i-1)||p.charAt(j-2)=='.')&&dp[i-1][j]?true:false;
                    }
                }
            }
        }
//=================================================
        for(int i=0;i<s.length()+1;i++){
            for(int j=0;j<p.length()+1;j++){
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }
//=================================================
        return dp[s.length()][p.length()];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s="aab";
        String p="c*a*b";
        System.out.println(solution.isMatch(s,p));
    }
}
