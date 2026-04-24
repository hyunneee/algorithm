#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
int main(void){
    int n;
    scanf("%d",&n);
    printf("%d %d",(int)(n*0.78),(int)(n*(0.8+0.2*0.78)));
    return 0;
}