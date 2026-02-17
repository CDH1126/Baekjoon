class Solution {
    public long solution(int n, int m) {
        long result = 1;
        
        for (int i = 1; i <= m; i++) {
            result = result * (n - i + 1) / i;
        }
        
        return result;
    }
}
