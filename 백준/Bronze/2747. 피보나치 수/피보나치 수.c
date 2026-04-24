#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {
    
    int num,i,tmp;
    int cur=1;
    int last=0;
    scanf("%d",&num);
    if(num<2)
    {
        if(num==0)
            printf("%d",last);
        else
            printf("%d",cur);
    }
    else
    {
        for(i=0;i<num-1;i++)
        {
            tmp=last+cur;
            last=cur;
            cur=tmp;
        }
        printf("%d",tmp);
    }
    
    return 0;
}