#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//3의 배수판정법 : 모든 자리의 수의 합이 3의 배수다.
//30의 배수판정법 : 3의 배수이고 & 일의자리가 0이다.

int compare(const void *a, const void *b)
{
    if(*(int*)a < *(int *)b)
        return 1;
    else if(*(int*)a > *(int*) b)
        return -1;
    else
        return 0;
}
int temp = 0;
int main(void){
    char s[100001];
    int arr[100001];
    int cnt=0;
    scanf("%s",s);
    //printf("%s\n",s);
    strtol(s,&arr,10);
    int size = strlen(s);
    //printf("size=%d\n",size);
    for(int i=0;i<size;i++){
        arr[i] = s[i]-'0';
        cnt += arr[i];
        //printf("s[%d] = %d, arr[%d] = %d\n",i,s[i],i,arr[i]);
    }
    qsort(arr, size, sizeof(arr[0]), compare);
    if(cnt%3==0&&arr[size-1]==0){
        for(int i=0;i<size;i++){
            printf("%d",arr[i]);
        }
        printf("\n");
    }
    else
        printf("-1\n");
    return 0;
}