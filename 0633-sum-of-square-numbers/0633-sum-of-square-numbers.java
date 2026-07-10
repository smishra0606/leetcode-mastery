class Solution {
    public boolean judgeSquareSum(int c) {
        long left=0;
        long right=c;
        long ans=left;
        long rightlimit=c-left*left;
        while(left<=right){
            long mid=left+(right-left)/2;
            long midSq=mid*mid;            
            if(midSq==rightlimit){
                return true;
            } 
            else if(midSq<rightlimit){
                ans=mid;
                left=mid+1;
            } 
            else{
                right=mid-1;
            }
        }
        left=0;
        rightlimit=ans;
        while (left <= rightlimit) {
            long currSum=left*left+rightlimit*rightlimit;            
            if (currSum==c){
                return true;
            } 
            else if(currSum<c){
                left++; 
            } 
            else{
                rightlimit--;
            }
        }        
        return false;
    }
}