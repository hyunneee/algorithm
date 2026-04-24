#include <stdio.h>
#include <stdlib.h>

int main(int argc, const char * argv[]) {
    int n,k;
   
    int* pArr;
    int sum[100];
    int num;
    scanf("%d %d",&n,&k);
    if(n==0){
        return 0;
    }
    pArr = (int*)malloc(sizeof(int) * n);
    for(int i=0;i<n;i++){
        scanf("%d",&pArr[i]);
        getchar();
    }
    for(int i=0;i<=n-k;i++){
        num=0;
        for(int j=i;j<i+k;j++){
            num+=pArr[j];
        }
        sum[i]=num;
    }
    int max=-10000;
    for(int i=0;i<=n-k;i++){
        if(sum[i]>max){
            max=sum[i];
        }
    }
    printf("%d",max);
    free(pArr);
    
    return 0;
}