class Solution {
    public int[] solution(int[] arr) {
        int[] result = new int[arr.length];
        int count = arr.length - 1;

        for (int i = 0; i < arr.length; i++){
            result[i] = arr[count];
            count--;
        }
        return result;
    }
}