class Solution {
    public int solution(int n) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        
        for (int i = 0; i < sb.length(); i++){
            answer += Integer.parseInt(String.valueOf(sb.charAt(i)));
        }
        
        return answer;
    }
}