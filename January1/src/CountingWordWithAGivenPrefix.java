// ps: https://leetcode.com/problems/counting-words-with-a-given-prefix/
// time complexity o(n)
// space complexity o(1)

public class CountingWordWithAGivenPrefix {
    public int prefixCount(String[] words, String pref) {
        int n = words.length;
        int count=0;
        for(int i=0;i<n;i++){
            if(words[i].startsWith(pref)){
                count++;
            }
        }
        return count;
    }
}
