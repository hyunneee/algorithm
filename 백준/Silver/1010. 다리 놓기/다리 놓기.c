#include <stdio.h>

int main(){
    int t,n,m;
    scanf("%d",&t);
    // printf("%d\n",t);
    for(int i=0;i<t;i++){
        int cnt = 1;
        scanf("%d %d",&n,&m);
        // printf("%d\n%d\n",n,m); 
        for(int j=1;j<=n;j++){
            cnt *= (m-(j-1));
            cnt /= j;
        }
        printf("%d\n",cnt);
        // printf("%d\n",facto(n,m));
    }
    return 0;
}