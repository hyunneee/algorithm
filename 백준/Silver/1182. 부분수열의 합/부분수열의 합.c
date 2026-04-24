#define _CRT_N0_SECURE_WARNINGS
#include <stdio.h>

int n,s;
int cnt=0;
int a[20]={0};

void func(int cur, int tot){
    if(cur ==n){
        if(tot==s)
            cnt++;
        return;
    }
    func(cur+1,tot);
    func(cur+1,tot+a[cur]);
}

int main(void){

    scanf("%d %d",&n,&s);
    for(int i=0;i<n;i++){
        scanf("%d",&a[i]);
    }
    func(0,0);
    if(s==0)
        cnt--;
    printf("%d\n",cnt);
    return 0;
}