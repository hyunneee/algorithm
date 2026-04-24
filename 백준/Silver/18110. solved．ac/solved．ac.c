#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int compare(const void *a, const void *b){
    int num1=*(int *)a;
    int num2=*(int *)b;
    
    if(num1<num2)
        return -1;
    else if(num1>num2)
        return 1;
    else
        return 0;
}

int main(void){
    
    int n;
    scanf("%d",&n);
    if(n==0){
        printf("0\n");
        return 0;
    }
    int arr[300001];
    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }
    
    qsort(arr,n,sizeof(int),compare);
    
    float x=n*0.15;
    x=round(x);
    float avg=0;
    //printf("%d\n",x);
    for(int i=x;i<n-x;i++){
        avg+=arr[i];
    }
    //printf("%d\n",avg);
    avg/=(n-2*x);
    avg=round(avg);
    printf("%d\n",(int)avg);
    /*
    for(int i=0;i<n;i++){
        printf("%d",arr[i]);
    }
    */
    
    return 0;
}
