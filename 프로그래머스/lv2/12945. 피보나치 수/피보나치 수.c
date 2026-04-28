#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {
    int answer = 0;
    long fibo[100001]={0,};
    fibo[0] = 0;
    fibo[1] = 1;
    for(int i=2;i<=n;i++){
        fibo[i] = (fibo[i-1]%1234567 + fibo[i-2]%1234567)%1234567;
    }
    answer = fibo[n];
    return answer;
}