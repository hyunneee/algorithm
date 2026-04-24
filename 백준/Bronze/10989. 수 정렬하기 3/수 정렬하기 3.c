#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int n;
    scanf("%d",&n);
    int num;
    int cnt[10001]={0,};
    
    for(int i=0;i<n;i++){
        scanf("%d",&num);
        cnt[num]+=1;
    }
    for(int i=1;i<10001;i++){
        while(cnt[i]!=0){
            printf("%d\n",i);
            cnt[i]-=1;
        }
    }
    
    return 0;
}
