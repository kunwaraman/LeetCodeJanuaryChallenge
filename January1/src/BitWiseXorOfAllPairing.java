import java.util.*;
// ps: https://leetcode.com/problems/xor-of-all-pairings/
// time complexity o(m+n)
// space complexity o(m+n)

public class BitWiseXorOfAllPairing {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums1){
            map.put(num,map.getOrDefault(num,0)+n);
        }
        for(int num:nums2){
            map.put(num,map.getOrDefault(num,0)+m);
        }
        int ans=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int ky=entry.getKey();
            int val=entry.getValue();
            if(val%2==1){
                ans=ans^ky;
            }
        }
        return ans;

    }
}
