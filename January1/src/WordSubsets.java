import java.util.*;
// ps: https://leetcode.com/problems/word-subsets/
// time complexity o(n*m)
// space complexity o(1)

public class WordSubsets {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int n = words1.length;
        ArrayList<String> list = new ArrayList<>();
        int freq2[] = new int[26];
        for(String word:words2){
            int temp[] = new int[26];// temp freq array of curent word
            for(char ch:word.toCharArray()){
                temp[ch-'a']++;
                freq2[ch-'a']=Math.max(freq2[ch-'a'],temp[ch-'a']);
            }
        }
        for(String word:words1){
            int temp[] = new int[26];
            for(char ch:word.toCharArray()){
                temp[ch-'a']++;
            }
            if(issubset(freq2,temp)){
                list.add(word);
            }
        }
        return list;
    }
    public boolean issubset(int freq2[],int[] temp){
        for(int i=0;i<26;i++){
            if(temp[i]<freq2[i]){
                return false;
            }
        }
        return true;
    }
}
