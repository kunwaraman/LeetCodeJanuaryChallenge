//ps : https://leetcode.com/problems/number-of-ways-to-split-array/
// time complexity o(n)
// space complexity o(1)

public class NumberOfWaysToSplitArrays {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        int ways=0;
        // long sumtotal=Arrays.stream(nums).sum(); // for large value it does not work
        long sumtotal=0;
        for(int i=0;i<n;i++){
            sumtotal+=nums[i];
        }
        long leftsum=0;
        long rightsum=0;
        for(int i=0;i<n-1;i++){
            leftsum+=nums[i];
            rightsum=sumtotal-leftsum;
            if(leftsum>=rightsum){
                ways++;
            }
        }
        return ways;

    }
}
