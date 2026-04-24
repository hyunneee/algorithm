#include <stdio.h>

int main(void){
    int T;
    scanf("%d",&T);
    for(int t=0;t<T;t++){
        int check[101]={0,};
        int max=0;
        int max2=0;
        int max_idx=0;
        int max2_idx=0;
        int arr[101][101]={0,}; //arr[V수만큼][C후보자수만큼]
        int cnt[101]={0,};
        int C;
        int V;
        
        scanf("%d %d",&C, &V);
        for(int i=0;i<V;i++){
            for(int j=0;j<C;j++){
                scanf("%d",&arr[i][j]);
            }
        }
        for(int i=0;i<V;i++){
            cnt[arr[i][0]]++;
        }
        
        for(int i=0;i<=C;i++){
            if(cnt[i]>max){
                max=cnt[i];
                max_idx=i;}
        }
        for(int i=0;i<=C;i++){
            if(cnt[i]>max2 && max2<=max && max_idx!=i){
                max2=cnt[i];
                max2_idx=i;
            }
        }
        if(max>=(double)V/2)
            printf("%d %d\n",max_idx,1);
        else{
            for(int i=1;i<C;i++){
                for(int j=0;j<V;j++){
                    if(arr[j][0]!=max_idx&&arr[j][0]!=max2_idx&&check[j]==0){
                        if(arr[j][i]==max_idx){
                            max++;
                            check[j]++;
                        }
                        else if(arr[j][i]==max2_idx){
                            max2++;
                            check[j]++;
                        }
                    }
                }
            }
            if(max>=(double)V/2)
                printf("%d %d\n",max_idx,2);
            else if(max2>=(double)V/2)
                printf("%d %d\n",max2_idx,2);
            }
        
    }
    return 0;
}