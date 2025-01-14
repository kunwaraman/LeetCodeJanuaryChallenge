import java.util.HashMap;
import java.util.Map;
// ps:https://leetcode.com/problems/minimum-length-of-string-after-removing-substrings/
    public class MinimumLengthOfStringAfterOperations {
        // the main key is odd hoga to 1 or even hoga to 2 each case
        public int minimumLength(String s) {
            int n = s.length();
            int res=0;
            HashMap<Character,Integer> map = new HashMap<>();
            for(char ch:s.toCharArray()){
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
            for(Map.Entry<Character,Integer> entry:map.entrySet()){
                int val=entry.getValue();
                if(val%2==0){
                    res+=2;
                }else{
                    res+=1;
                }

            }
            return res;

        }
    }
    public class Solution{
        // to find freq via map
        public int minimumLength(String s) {
            int n = s.length();
            HashMap<Character,Integer> map = new HashMap<>();
            int res=0;
            for(char ch:s.toCharArray()){
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.get(ch)==3){
                    map.put(ch,map.get(ch)-2);
                }
            }
            for(Map.Entry<Character,Integer> entry:map.entrySet()){
                int val=entry.getValue();
                res+=val;
            }
            return res;


        }
    }
    public class solution2{
        // count via array freq
        // time complexity O(n)
        // space complexity O(1) contant space
        public int minimumLength(String s) {
            int n = s.length();
            int freq[] = new int[26];
            int delete=0;
            for(char ch:s.toCharArray()){
                freq[ch-'a']++;
                if(freq[ch-'a']==3){
                    freq[ch-'a']-=2;
                    delete+=2;
                }
            }
            return n-delete;

        }
    }


}
