package no12.整数转罗马数字;
//题目输入数字小于4000
public class Solution {
    char list[][]={{'I','V'},{'X','L'},{'C','D'},{'M','&'}};
    public String convert(int num,int index/*指数*/){
        String result="";
        switch (num){
            case 0: return "";
            case 4:
                result=String.valueOf(list[index][0])+String.valueOf(list[index][1]);
                break;
            case 9:
                result=String.valueOf(list[index][0])+String.valueOf(list[index+1][0]);
                break;
            default:
                if(num<5){
                    for(int i=0;i<num;i++){
                        result+=String.valueOf(list[index][0]);
                    }
                }else{
                    result+=String.valueOf(list[index][1]);
                    result+=convert(num-5,index);
                }break;
        }
        return result;
    }
    public String intToRoman(int num) {
        int nums[]=new int[4];
        String result="";
        for(int i=0;i<4;i++){
            nums[i]=num%10;
            num/=10;
        }
        for(int i=3;i>=0;i--){
            result+=convert(nums[i],i);
        }
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int num=1994;
        System.out.println(solution.intToRoman(num));
    }
}

