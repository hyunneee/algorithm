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

int lower(int key,int data[],int n){
    int low=0, high=n-1,mid;
    while(1){
        mid=(low+high)/2;
        if(low>high){
            if(data[low]==key)
                return low;
            else return -1;
        }
        if(data[mid]>=key)
            high=mid-1;
        else low=mid+1;
    }
}

int upper(int key,int data[],int n){
    int low=0, high=n-1,mid;
    while(1){
        mid=(low+high)/2;
        if(low>high){
            if(data[high]==key)
                return high;
            else return -1;
        }
        if(data[mid]<=key)
            low=mid+1;
        else high=mid-1;
    }
}


int main(void){
    int n,m;
    int num[500001];
    
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        scanf("%d ",&num[i]);
    }
    qsort(num,n,sizeof(int),compare);
    
    int key;
    scanf("%d",&m);
    for(int i=0;i<m;i++){
        scanf("%d",&key);
        int result=0;
        result=upper(key,num,n);
        if(result==-1)
            printf("0 ");
        else{
            result-=lower(key,num,n);
            result+=1;
            printf("%d ",result);
        }
    }

    return 0;
}
