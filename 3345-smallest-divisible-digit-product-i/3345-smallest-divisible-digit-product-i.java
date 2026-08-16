class Solution {
    public int digit(int n){
        int pro=1;
        while(n>0){
            int temp=n%10;
            pro*=temp;
            n=n/10;
        }
        return pro;
    }
    public int smallestNumber(int n, int t) {
        int curr=n;
        while(true){
            if(digit(curr)%t==0){
                return curr;
            }
            curr++;
        }
    }
}