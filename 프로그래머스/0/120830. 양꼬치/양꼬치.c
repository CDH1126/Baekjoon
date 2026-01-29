#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n, int k) {
    
    if (n >= 10) {
        int value = n / 10;
        k = k - value;
    }
    int result = (n*12000) + (k*2000);
    return result;
}