#include <stdio.h>
#include <stdlib.h>

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

int binsearch(int data[],int n,int key){
    int mid;
    int low=0;
    int high=n-1;
    while(low<=high){
        mid=(low+high)/2;
        if(key==data[mid])
            return mid;
        else if(key<data[mid]){
            high=mid-1;
        }
        else if(key>data[mid])
            low=mid+1;
    }
    return -1;
}

int main(void){
    int n,m;
    int num[100001];
    
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        scanf("%d ",&num[i]);
    }
    //오름차순으로 번경
    qsort(num,n,sizeof(int),compare);

    int key;
    scanf("%d",&m);
    for(int i=0;i<m;i++){
        scanf("%d",&key);
        int idx=binsearch(num,n,key);
        if(idx==-1)
            printf("0\n");
        else
            printf("1\n");
    }
    return 0;
}
