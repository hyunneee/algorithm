#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
int main(void){
    int n,k;
    int i,j=1;
    int arr1[5001]={0};
    int count;
    scanf("%d %d",&n,&k);
    printf("<");
    for(i=0;i<n;i++){
        count=0;
        while(1){
            if(arr1[j]==0)
                count++;
            if(count==k){
                arr1[j]=-1;
                if(i==n-1)
                    printf("%d>",j);
                else
                    printf("%d, ",j);
                break;}
            j++;
            if(j>n) j=1;
        }
    }
    return 0;
}
