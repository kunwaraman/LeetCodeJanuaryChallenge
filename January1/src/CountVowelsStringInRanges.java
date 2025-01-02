public class CountVowelsStringInRanges {
    // time complexity o(n)+o(q)
    // space complexity o(n)
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int q = queries.length;
        int csum[] = new int[n];
        int res[] = new int[q];
        int sum=0;
        for(int i=0;i<n;i++){ // o(n)
            if(isvowel(words[i].charAt(0)) && isvowel(words[i].charAt(words[i].length()-1))){
                sum++;
            }
            csum[i]=sum;
        }
        for(int i=0;i<q;i++){ //o(q)
            int l=queries[i][0];
            int r=queries[i][1];

            res[i]=csum[r]-(l>0 ?csum[l-1]:0);
        }
        return res;
    }
    public boolean isvowel(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
}
