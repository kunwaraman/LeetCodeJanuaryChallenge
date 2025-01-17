public class NeighBoringBitwiseXor {
    // time complexity O(n)
    // space complexity O(n) // we can say that constant because we not consider result as a space
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int original[] = new int[n];
        original[0]=0;
        for(int i=0;i<n-1;i++){
            original[i+1]=original[i]^derived[i];

        }
        if((original[n-1]^original[0])==derived[n-1]){
            return true;
        }
        original[0]=1;
        for(int i=0;i<n-1;i++){
            original[i+1]=derived[i]^original[i];
        }
        if((original[n-1]^original[0])==derived[n-1]){
            return true;
        }
        return false;
    }



    // another approach
    public boolean doesValidArrayExistAnotherApproach(int[] derived) {
        // time complexity O(n)
        // space complexity O(1)
        int xor=0;
        for(int xr:derived){
            xor=(xor^xr);
        }
        if(xor==0){
            return true;
        }else{
            return false;
        }
    }
}

/*
main rule of xor is
X^Y=Z
Z^Y=X
Z^X=Y

 agar X^Y ==z hai to kishi do number ko xor kar do to x ko z se ya z ko y se
 to tishra number nikal jata hai



 */
