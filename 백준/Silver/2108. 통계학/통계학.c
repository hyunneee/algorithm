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

int average(int arr[],int n){
    double avg=0;
    for(int i=0;i<n;i++){
        avg+=arr[i];
    }
    return round(avg/n);
}

int midth(int arr[],int n){
    int mid = 0;
    if(n==1)
        mid=arr[0];
    else
        mid=arr[(n+1)/2-1];
    return mid;
}
int mode(int arr[],int n){
    int list[8001]={0,};
    int idx=0;
    int max=0;
    int cnt=0;
    for(int i=0;i<n;i++){
        idx=arr[i]+4000;
        //printf("%d\n",idx);
        list[idx]+=1;
        if(list[idx]>max){
            max=list[idx];
            //printf("%d, %d\n",max,idx);
        }
    }
    int cnt_idx=0;
    for(int i=0;i<8001;i++){
        if(list[i]==0)
            continue;
        if(list[i]==max){
            if(cnt==0){
                cnt_idx=i;
                cnt+=1;
                //printf("%d, %d\n",cnt,cnt_idx);
            }
            else if(cnt==1){
                cnt_idx=i;
                break;
            }
        }
    }
    return cnt_idx-4000;
}
int range(int arr[],int n){
    return arr[n-1]-arr[0];
}

int main(void){
    int n;
    int arr[500001];
   
    scanf("%d",&n);
    
    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }
    qsort(arr,n,sizeof(int),compare);
    
    printf("%d\n",average(arr,n));
    printf("%d\n",midth(arr,n));
    printf("%d\n",mode(arr,n));
    printf("%d\n",range(arr,n));
    
    return 0;
}
