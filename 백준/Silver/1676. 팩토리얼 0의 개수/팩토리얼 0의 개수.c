#include<stdio.h>

int main(void){
    int n;
    int cnt=0;
    scanf("%d",&n);
    if(n>=125){
        cnt += (n/125);
    }
    if(n>=25){
        cnt += (n/25);
    }
    if(n>=5){
        cnt += (n/5);
    }
    printf("%d\n",cnt);
    
    return 0;
}
