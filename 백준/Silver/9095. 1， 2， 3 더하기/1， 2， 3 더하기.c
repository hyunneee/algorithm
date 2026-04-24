#include<stdio.h>

int add[12];

int main(void){
    int t,n;
    scanf("%d",&t);
    add[1] = 1;
    add[2] = 2;
    add[3] = 4;
    for(int i=4;i<=12;i++){
        add[i] = add[i-1] + add[i-2] + add[i-3];
    }
    for(int i=0;i<t;i++){
        scanf("%d",&n);
        printf("%d\n",add[n]);
    }
    return 0;
}
