package no8.字符串转换整数;
//测试用例真尼玛无聊
public class Solution {
    public int myAtoi(String s) {
        int i=0,result=0,temp;
        boolean isNegative=false,isOverFlowed=false;
        if(s.length()==0) {
            System.out.println("nmsl");
            return result;
        }
        while(i<s.length()&&s.charAt(i)==' '){
            i++;
        }
        if(i<s.length()&&(s.charAt(i)=='-'||s.charAt(i)=='+')) {
            isNegative=s.charAt(i)=='-'?true:false;
            i++;
        }
        while(i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
            temp=result;
            result=result*10+s.charAt(i)-48;
            if((result-s.charAt(i)+48)/10!=temp){
                isOverFlowed=true;
                break;
            }
            i++;
        }
        if(isOverFlowed||result<0)
            return isNegative?Integer.MIN_VALUE:Integer.MAX_VALUE;
        return isNegative?-1*result:result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("-42"));
    }
}
