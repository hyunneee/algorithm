#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void){
    int N;
    scanf("%d",&N);
    int arr[N];
    int sum=0;
    for(int i=0;i<N;i++){
        scanf("%1d",&arr[i]); //한 글자씩 받아서 arr배열에 넣기!!!
        sum+=arr[i];}
    printf("%d",sum);
    return 0;
}
