class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        int num = 0;
        int max = 0;
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                num = i ;
                max = array[i];
            }
        }
        answer[0] = max;
        answer[1] = num;
        return answer;
    }
}