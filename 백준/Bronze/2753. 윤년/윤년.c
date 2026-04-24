#include<stdio.h>

int main(void){
    int a;
    scanf("%d",&a);
    if((a%400) && ((a%4) || !(a%100))){ //if(0)이면 거짓
       printf("0\n"); 
    }
    else{
        printf("1\n");
    }

    return 0;
}