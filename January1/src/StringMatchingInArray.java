import java.util.*;
// brute force accepted
// time complexity o(n^2)
// space complexity o(n) but could be o(1) because we not consider result as a space
// ps: https://leetcode.com/problems/string-matching-in-an-array/
public class StringMatchingInArray {
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                if(words[j].contains(words[i])){
                    list.add(words[i]);
                    break;
                }
            }
        }
        return list;
    }
}
