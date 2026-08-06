class Solution {
    public int addDigits(int num) {
        while(num>=10){        
            int curr=num;
            int res=0;
            while(curr>0){
                int temp=curr%10;  
                res+=temp;          
                curr=curr/10;            
            }
            num=res;
        }
        return num;
    }
}