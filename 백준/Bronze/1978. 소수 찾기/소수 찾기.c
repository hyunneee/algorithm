#include <stdio.h>
#include <math.h>

int n;
int arr[101];
int cnt = 0;

void prime(int x){
    int p = 0;
    if (x==1){
        return ;
    }
    for(int i = 2; i<sqrt(x)+1;i++){
        if(x%i == 0 && x!=2){
            p = -1;
            break;
        }
    }
    if(p==0){
        cnt++;
        // printf("%d\n",x);
    }

}
int main(void){
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);
        prime(arr[i]);
    }
    printf("%d\n",cnt);
    return 0;
}