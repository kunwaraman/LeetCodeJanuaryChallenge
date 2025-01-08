// time complexity o(n^2)
// space complexity o(1)
// brute force accepted
// ps: https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/

public class CountPrefixAndSuffixPairsi {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                String str1=words[i];
                String str2=words[j];
                if(str1.length()>str2.length()){
                    continue;
                }
                if(str2.startsWith(str1) && str2.endsWith(str1)){
                    count++;
                }
            }
        }
        return count;

    }
}
