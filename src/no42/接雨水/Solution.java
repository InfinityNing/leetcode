package no42.接雨水;

/**
 * 时间复杂度o(n²)
 * 正确解法使用两次循环，一次循环记录左侧最大值，一次循环记录右侧最大值，类似递推
 * 最终时间复杂度o(n)
 */
public class Solution {//o(n)
    public int trap(int[] height) {
        if(height.length==0) return 0;
        int[] maxLeft=new int[height.length],maxRight=new int[height.length];
        maxLeft[0]=0;
        maxRight[maxRight.length-1]=0;
        int total=0,temp;
        for(int i=1;i<height.length;i++){
            maxLeft[i]=Math.max(maxLeft[i-1],height[i-1]);
            maxRight[maxRight.length-1-i]=Math.max(maxRight[maxRight.length-i],height[maxRight.length-i]);
        }
        for(int i=0;i<height.length;i++){
            temp=Math.min(maxLeft[i],maxRight[i])-height[i];
            total=temp>0?total+temp:total;
        }
        return total;
    }
//    public int findMin(int a,int b){
//        return a>b?b:a;
//    }
//    public int trap(int[] height) {
//        int j,k,result=0;
//        int maxL,maxR;
//        int[] depth=new int[height.length];
//        for(int a=0;a<depth.length;a++){
//            depth[a]=0;
//        }
//        for(int i=1;i<height.length-1;i++){
//            j=i;k=i;
//            maxL=0;maxR=0;
//            while(j>=0){
//                if(height[j]>maxL){
//                    maxL=height[j];
//                }
//                j--;
//            }
//            while(k<height.length){
//                if(height[k]>maxR){
//                    maxR=height[k];
//                }
//                k++;
//            }
//            if(findMin(maxL,maxR)>height[i]){
//                depth[i]=findMin(maxL,maxR)-height[i];
//            }
//        }
//        for(int a=0;a<depth.length;a++){
//            result+=depth[a];
//        }
//        return result;
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a={4,2,0,3,2,5};
        int[] b={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(a));
        System.out.println(solution.trap(b));
    }
}
