#include<stdio.h>

int main(void){
    int arr[10];
    int max = 0;
    int num = -1;
    for(int i=0;i<9;i++){
        scanf("%d",&arr[i]);
    }
    for(int i=0;i<9;i++){
        if(arr[i]>max){
            max = arr[i];
            num = i;
        }
    }
    printf("%d\n",max);
    printf("%d\n",num+1);
    return 0;
}