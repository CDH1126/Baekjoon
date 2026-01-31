import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        int result = 0;
        Arrays.sort(numbers);
        
        int length = numbers.length - 1;
        result = numbers[length];
        
        length --;
        result = result * numbers[length];
        
        
        return result;
        
    }
}