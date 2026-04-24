#include <stdio.h>
#define MAX_N 1000000

int dp[MAX_N+1]={0,};
int search(int n,int check,int cnt);
// int cnt=0;

int main(void){
    int n;
    scanf("%d",&n);
    dp[1] = 0;
    for(int i=2;i<=n;i++){
        dp[i] = dp[i-1]+1;
        if(i%3==0){
            if(dp[i]>dp[i/3]+1){
                dp[i] = dp[i/3]+1;
            } 
        }
        if(i%2==0){
            if(dp[i]>dp[i/2]+1){
                dp[i] = dp[i/2]+1;
            } 
        }
    }
    printf("%d\n",dp[n]);
   
    return 0;
}