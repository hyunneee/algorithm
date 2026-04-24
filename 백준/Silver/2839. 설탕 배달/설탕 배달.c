#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void){
    int num,A=0,B=0,i;
    scanf("%d",&num);
    if(num%5==0)
        A=num/5;
    else if(num%3==0)
        A=num/3;
    for(i=num/5;i>0;i--){
        if((num-5*i)%3==0)
        {
            B=(num-5*i)/3+i;
            break;
        }
    }
    if((A==0)&&(B==0)){
        printf("%d \n",-1);
        return 0;
    }
    if(B==0)
        printf("%d \n",A);
    else
        printf("%d \n",B);
    return 0;
}