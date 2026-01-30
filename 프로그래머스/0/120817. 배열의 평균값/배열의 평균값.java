class Solution {
    public double solution(int[] numbers) {
        double result = 0;
        for(int i=0; i <= numbers.length-1; i++){
            result = result + numbers[i];
        }
        return (result / numbers.length);
    }
}