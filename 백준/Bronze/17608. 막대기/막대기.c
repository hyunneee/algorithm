#include <stdio.h>

int main(){
    int n,max;
    int arr[100000];
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);
        max=arr[i];}
    int count=1;
    for(int i=n-2;i>=0;i--){
        if(max<arr[i]){
            max=arr[i];
            count++;}}
    printf("%d",count);
    
    return 0;
    }