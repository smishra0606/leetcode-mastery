 class Solution {
    public int minimumChanges(String s, int k) {
        int strLen = s.length();
        int[][] cost = new int[strLen][strLen];
        for (int left = 0; left < strLen; left++) {
            for (int right = left + 1; right < strLen; right++) {
                int segLen = right - left + 1;
                int minModifications = Integer.MAX_VALUE;
                for (int divisor = 1; divisor < segLen; divisor++) {
                    if (segLen % divisor == 0) {
                        int currentModifications = 0;
                        int groupCount = segLen / divisor;
                        for (int offset = 0; offset < divisor; offset++) {
                            int startIdx = 0;
                            int endIdx = groupCount - 1;
                            while (startIdx < endIdx) {
                                char charA = s.charAt(left + offset + startIdx * divisor);
                                char charB = s.charAt(left + offset + endIdx * divisor);
                                if (charA != charB) {
                                    currentModifications++;
                                }
                                startIdx++;
                                endIdx--;
                            }
                        }
                        if (currentModifications < minModifications) {
                            minModifications = currentModifications;
                        }
                    }
                }
                cost[left][right] = minModifications;
            }
        }
        int[][] dp = new int[k + 1][strLen + 1];
        int INF = 1000000;
        for (int parts = 0; parts <= k; parts++) {
            for (int len = 0; len <= strLen; len++) {
                dp[parts][len] = INF;
            }
        }
        dp[0][0] = 0;
        for (int parts = 1; parts <= k; parts++) {
            for (int end = parts * 2; end <= strLen; end++) {
                for (int start = (parts - 1) * 2; start <= end - 2; start++) {
                    int candidate = dp[parts - 1][start] + cost[start][end - 1];
                    if (candidate < dp[parts][end]) {
                        dp[parts][end] = candidate;
                    }
                }
            }
        }
        return dp[k][strLen];
    }
 }
                    
