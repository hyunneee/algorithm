#include <stdio.h>

int main()
{
    int n;
    int a,b,c;
    int num;
    scanf("%d",&n);
    num=n;
    int cycle=1;
    while(1){
        a=num/10;
        b=num%10;
        c=a+b; 
        c%=10;
        num=b*10+c;
        if(n==num)
            break;
        else
            cycle++;
    }
    printf("%d",cycle);

    return 0;
}