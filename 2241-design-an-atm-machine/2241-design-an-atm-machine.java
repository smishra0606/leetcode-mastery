class ATM {
    public long[] bank;
    public int[] values;
    
    public ATM() {
        bank = new long[5];
        values = new int[]{20, 50, 100, 200, 500};
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i = 0; i < 5; i++){
            bank[i] += banknotesCount[i];
        }
    }
    
    public int[] withdraw(int amount) {
        int[] result = new int[5];
        int remaining = amount;
        
        for (int i = 4; i >= 0; i--) {
            if (remaining <= 0) break;
            
            // Find how many notes of values[i] we need vs how many we actually have
            long needed = remaining / values[i];
            long used = Math.min(needed, bank[i]);
            
            // Deduct the used amount from our remaining total
            remaining -= used * values[i];
            result[i] = (int) used;
        }
        
        // If we can fulfill the exact amount, apply the changes to the bank
        if (remaining == 0) {
            for (int i = 0; i < 5; i++) {
                bank[i] -= result[i];
            }
            return result;
        } 
        // If we cannot fulfill it, reject the transaction and return [-1]
        else {
            return new int[]{-1};
        }
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */