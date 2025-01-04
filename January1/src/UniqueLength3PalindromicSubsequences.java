import java.util.*;

// ps: https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
// time complexity o(n)
// space complexity o(n)

public class UniqueLength3PalindromicSubsequences {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        for(char ch:s.toCharArray()){
            set.add(ch);
        }
        int res=0;
        for(char st:set){
            int leftidx=-1;
            int rightidx=-1;
            for(int i=0;i<n;i++){
                if(s.charAt(i)==st){
                    if(leftidx==-1){ // means they are 1st occurenece
                        leftidx=i;
                    }
                    rightidx=i;
                }
            }
            HashSet<Character> set1 = new HashSet<>();
            for(int mid=leftidx+1;mid<=rightidx-1;mid++){
                set1.add(s.charAt(mid));

            }
            res+=set1.size();
        }
        return res;

    }
}
