#include <stdio.h>


int main(void){
    int T;
    int N;
    long long sum[1000001] = {0};
    for(int i=1;i<=1000000;i++){
        for(int j=1;i*j<=1000000;j++){
            sum[i*j] +=i;
        }
        sum[i] += sum[i-1];
    }

    scanf("%d",&T);

    for(int i=0;i<T;i++){
        scanf("%d",&N);
        
        printf("%lld\n",sum[N]);
    }
    return 0;
}