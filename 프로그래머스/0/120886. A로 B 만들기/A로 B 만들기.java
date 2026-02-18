class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        
        int [] count = new int[26];
        for (int i = 0; i < before.length(); i++) {
            count[before.charAt(i) - 'a'] ++;
            count[after.charAt(i) - 'a'] --;
        }
        
        for (int c : count) {
            if(c != 0) {
                return 0;
            }
        }
        
        return 1;
    }
}