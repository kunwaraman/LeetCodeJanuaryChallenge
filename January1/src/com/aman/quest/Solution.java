package com.aman.quest;

// ps : https://leetcode.com/problems/maximum-score-after-splitting-a-string/
class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int totalone=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                totalone++;
            }
        }
        int zero=0;
        int one=0;
        for(int i=0;i<=n-2;i++){
            if(s.charAt(i)=='0'){
                zero++;
            }else{
                one++;
            }
            int rightone=totalone-one;
            max=Math.max(max,zero+rightone);
        }
        return max;
        
    }
}