
// ps : https://leetcode.com/problems/shifting-letters-ii/
// time complexity o(n)
// space complexity o(n)
public class ShiftingLettersII {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int diff[] = new int[n];
        for(int shift[]:shifts){
            int left=shift[0];
            int right=shift[1];
            int direc=shift[2];

            int x = 0;
            if(direc==0){
                x=-1;
            }else{
                x=1;
            }
            diff[left]+=x;
            if(right+1<n){
                diff[right+1]-=x;
            }
        }
        // to findcsum;
        for(int i=1;i<n;i++){
            diff[i]+=diff[i-1];
        }

        // apply the shift hcnages
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            int shift=diff[i]%26;
            if(shift<0){
                shift+=26;
            }
            char newchar = (char)(((s.charAt(i)-'a' + shift)%26)+'a');
            sb.append(newchar);
        }
        return sb.toString();
    }
}
