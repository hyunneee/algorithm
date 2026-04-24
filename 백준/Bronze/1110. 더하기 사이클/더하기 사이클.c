#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {
    int user,num,a1,a2,a3;
    int count=0;
    scanf("%d",&user);
    num=user;
    do{
        a1=num/10;
        a2=num%10;
        a3=(a1+a2)%10;
        count++;
        num=a2*10+a3;
    }while(user!=num);
    printf("%d",count);
}