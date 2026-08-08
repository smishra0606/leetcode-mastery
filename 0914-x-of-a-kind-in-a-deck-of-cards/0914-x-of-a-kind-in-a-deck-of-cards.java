import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        
        Map<Integer, Integer> counts = new HashMap<>();
        for (int card : deck) {
            counts.put(card, counts.getOrDefault(card, 0) + 1);
        }
        
        int commonGcd = 0;
        for (int frequency : counts.values()) {
            commonGcd = gcd(commonGcd, frequency);
        }
        return commonGcd >= 2;
    }
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
