#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
int main(void){
    int V,A,B;
    int day,almost,howmany;
    scanf("%d",&A);
    scanf("%d",&B);
    scanf("%d",&V);
    if(A==V){
       printf("%d",1);
        return 0;}
    day=A-B;
    almost=V-A;
    if(almost%day==0)
        howmany=almost/day;
    else
        howmany=(almost/day)+1;
    printf("%d",howmany+1);
    return 0;
}