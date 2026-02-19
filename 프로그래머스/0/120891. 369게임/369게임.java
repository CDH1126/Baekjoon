class Solution {
    public int solution(int order) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder(String.valueOf(order));
        for (int i = 0; i < sb.toString().length(); i++) {
            if(sb.charAt(i) == '3' ||
                sb.charAt(i) == '6' ||
                sb.charAt(i) == '9') {
                answer ++;
            }
        }
        
        return answer;
    }
}