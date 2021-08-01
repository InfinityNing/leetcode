package no30.串联所有单词的子串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//思想是把给定数组中的字符串以<String,int>形式存入hashmap，int记录出现次数 e.g.[good,good]
//然后用一个空的hashmap装子串中提取出的字符串，若找不到或出现次数多于标准的map就false
public class Solution {
    public boolean pairs(String subString,HashMap<String,Integer> map,HashMap<String,Integer> rawMap,int length){
        HashMap<String, Integer> temp=(HashMap<String, Integer>)rawMap.clone();
        String ss;
        for(int i=0;i<subString.length();i+=length){
            ss=subString.substring(i,i+length);
            if(!temp.containsKey(ss)||temp.get(ss)>=map.get(ss)) return false;
            else temp.put(ss,temp.get(ss)+1);
        }
        return true;
    }
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer>result=new ArrayList<>();
        if(words.length==0) return result;
        int subLength=words.length*words[0].length();
        String subString;
        HashMap<String, Integer> map=new HashMap(),rawMap=new HashMap<>();
        for(String word:words){
            if(!map.containsKey(word))map.put(word,1);//标准map记录出现次数
            else map.put(word,map.get(word)+1);
            rawMap.put(word,0);//空map全为0
        }
        for(int i=0;i<s.length()-subLength+1;i++){
            subString=s.substring(i,i+subLength);
            if(pairs(subString,map,rawMap,words[0].length()))
                result.add(i);
        }
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1="barfoothefoobarman",s2 = "wordgoodgoodgoodbestword",
                s3="lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words1={"foo","bar"},words2 ={"word","good","best","word"},
                words3={"fooo","barr","wing","ding","wing"};
        System.out.println(solution.findSubstring(s1,words1));
        System.out.println(solution.findSubstring(s2,words2));
        System.out.println(solution.findSubstring(s3,words3));
    }
}


