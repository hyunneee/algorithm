#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void){
    int C=0,N=0;
    scanf("%d",&C);
    for(int i=0;i<C;i++){
        scanf("%d",&N);
        int score[1000],sum=0;
        double avg=0.0;
        for(int j=0;j<N;j++){
            scanf("%d",&score[j]);
            sum+=score[j];
        }
        avg=(double)sum/N;
        int count=0;
        for(int j=0;j<N;j++)
            if(score[j]>avg)
                count++;
        printf("%.3f%%\n",(double)count/N*100);
    }
    return 0;
}