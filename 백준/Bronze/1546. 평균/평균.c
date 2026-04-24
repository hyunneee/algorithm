#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void){
    int num,M=0,i;
    double total=0.0;
    scanf("%d \n",&num);
    double score[num];
    for(i=0;i<num;i++){
        scanf("%lf",&score[i]);} //double형은 scanf쓸 때 %lf를 쓴다. float는 %f
    for(i=0;i<num;i++)
        if(score[i]>M)
            M=score[i];
    for(i=0;i<num;i++){
        score[i]=(score[i]/M)*100;
        total+=score[i];
        }
    printf("%0.2lf ",total/num);
    
    return 0;
}