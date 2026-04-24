#include <stdio.h>
#include <stdlib.h>

// 최소 로프 중량에 걸리지도 않으면서 && 모든 로프 중량의 평균
// 10 20 30 25 
// 10하는 건 85/4 = 21.x 30
// 10을 버려 20+30+25/3 =25 60
// 25하는건 50이지
// 30은 하나...
// 10 20 25 30 (4)
// 4-0=4// 4-1
// 최악의 상황 10자리수

int compare(const void *a, const void *b) //오름차순!
{
    if(*(int*)a > *(int *)b)
        return 1;
    else if(*(int*)a < *(int*) b)
        return -1;
    else
        return 0;
}

int main(void){
    int n;
    int arr[100001];
    int weight[100001];
    int max=-1;

    scanf("%d",&n);
    //printf("%d",n);
    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);
        //printf("%d\n",arr[i]);
    }
    qsort(arr, n, sizeof(arr[0]), compare);
    for(int i=0;i<n;i++){
        weight[i]=arr[i] * (n-i);
        if(weight[i]>max) max=weight[i];
    }
    printf("%d\n",max);
    return 0;
}