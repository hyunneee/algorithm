#include <stdio.h>
#include <stdlib.h>

int main(void){
    int n,k;
    int arr[11];
    int check = 0;
    int idx=0;
    int cnt=0;
    scanf("%d %d",&n,&k);
    
    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }
    int i = n-1;
    while(k>0){
        if(arr[i]>k){
            i--;
        }
        else{
            cnt += (k/arr[i]);
            k = k%arr[i];
        }
    }
    printf("%d\n",cnt);

    return 0;
}