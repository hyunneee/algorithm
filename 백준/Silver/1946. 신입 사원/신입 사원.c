#include <stdio.h>
#include <stdlib.h>

typedef struct{
    int first;
    int second;
} element;

int compare(const void* a, const void* b){
    if(((element *)a)->first > ((element *)b)->first)
        return 1;
    else if(((element *)a)->first < ((element *)b)->first)
        return -1;
    else
       return 0;
}

int main(void){
    int t;
    scanf("%d",&t);
    while(t--){
        int n;
        scanf("%d",&n);
        element candi[n];

        for(int i=0;i<n;i++){
            scanf("%d %d",&candi[i].first,&candi[i].second);
        }
        
        qsort((element*)candi,n,sizeof(element),compare);
        element rank1 = candi[0];
        int cnt=1;
        for(int i=0;i<n;i++){
            if(rank1.second>candi[i].second){
                cnt++;
                rank1 = candi[i];
            }
        }
        // for(int i=0;i<n;i++){
        //     printf("%d %d\n",candi[i].first,candi[i].second);
        // }
        printf("%d\n",cnt);
    }
    
    return 0;
}