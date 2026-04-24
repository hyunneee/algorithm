#include<stdio.h>

int main(void){
    int a;
    scanf("%d",&a);
    if(a%400==0 || (a%4==0 && (a%100)!=0)){ //if(0)이면 거짓
       printf("1\n"); 
    }
    else{
        printf("0\n");
    }
    return 0;
}