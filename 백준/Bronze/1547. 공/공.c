#include <stdio.h>

int main(void) {
    int cup[3]={0,-1,-1};
    int a,b,M;
    scanf("%d",&M);
    for(int i=0;i<M;i++){
        scanf("%d %d",&a,&b);
        int temp=0;
        temp=cup[a-1];
        cup[a-1]=cup[b-1];
        cup[b-1]=temp;
        }
    for(int i=0;i<3;i++){
    if(cup[i]==0)
        printf("%d",i+1);}
    return 0;
}
