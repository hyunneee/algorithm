#include<stdio.h>

void swap(int* a,int* b){
    int t;
    t = *a;
    *a = *b;
    *b = t;
}
int main(void){
    int order[102];
    int result[102];
    int n;
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        result[i]=i+1;
    }
    for(int i=0;i<n;i++){
        scanf("%d",&order[i]);
    }
    int t;
    for(int i=1;i<=n;i++){
        t = order[i-1];
        if(!t){
            // printf("%d\n",i);
            continue;
        }
        else{
            for(int j=i-t;j>0&&j<i;j++){
                swap(&result[j-1],&result[i-1]);
                // printf("j=%d,i=%d\n",j,i);
                // printf("%d %d\n",result[j],result[i]);
                // for(int k=0;k<n;k++){
                //     printf("%d ",result[k]);
                // }
                // printf("\n");
            }
        }
    }
    for(int i=0;i<n;i++){
        printf("%d ",result[i]);
    }
    return 0;
}