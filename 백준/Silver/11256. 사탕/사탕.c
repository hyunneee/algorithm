#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b)
{
    if(*(int*)a < *(int *)b)
        return 1;
    else if(*(int*)a > *(int*) b)
        return -1;
    else
        return 0;
}

int main(void){
    int t;
    scanf("%d",&t);
    while(t--){
        int j,n;
        int arr[1000];
        scanf("%d %d",&j,&n);
        //printf("j= %d n= %d \n",j,n);
        for(int i=0;i<n;i++){
            int r,c;
            scanf("%d %d",&r,&c);
            arr[i] = r*c;
            //printf("r= %d c= %d arr[%d] = %d\n",r,c,i,arr[i]);
        }
        qsort(arr, n, sizeof(arr[0]), compare);
        
        // for(int i=0;i<n;i++){
        //     printf("arr[%d] = %d\n",i,arr[i]);
        // }
        int min_box = 0;
        int k;
        for(k=0;min_box<j;k++){
            min_box+=arr[k];
        }
        
        //printf("min_box = %d, k = %d\n",min_box,k);
        printf("%d\n",k);
    }   
    
    return 0;
}