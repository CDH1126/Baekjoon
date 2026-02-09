class Solution {
    public int solution(int slice, int n) {
        
        int result = n / slice;
        int a = n % slice ;
        if (a > 0) {
            result ++;
        } 
        
        return result;
    }
}