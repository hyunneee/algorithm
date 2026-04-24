#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {
    int arr[5][4];
    int i,j,k,l;
    int sum=0;
    int max=0;
    int maxp=0;
    for(i=0;i<5;i++)
    {
        for(j=0;j<4;j++)
        {
            scanf("%d ",&arr[i][j]);
        }
    }
    for(k=0;k<5;k++)
    {
        for(l=0;l<4;l++)
            sum+=arr[k][l];
        if(sum>max)
        {
            maxp=k+1;
            max=sum;
        }
        sum=0;
    }
    printf("%d %d",maxp,max);
    return 0;
}