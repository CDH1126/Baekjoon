class Solution {
    public int[] solution(int[] num_list) {
        int[] arr = new int[2];
        int a = 0;
        int b = 0;
        for(int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 == 0) {
                b++;
            } else {
                a++;
            }
        }
        arr[0] = b;
        arr[1] = a;
        
        return arr;
    }
}