#include<stdio.h>
int card[20];
int main(void){
    int a,b;
    int i,j;
    for(i=0;i<20;i++){
        card[i]=i+1;
    }
    for(i=0;i<10;i++){
        scanf("%d %d",&a,&b);
        for(j=a-1;j<b;j++){
            int temp=0;
            temp=card[j];
            card[j]=card[b-1];
            card[b-1]=temp;
            b--;
        }
    }
    for(i=0;i<20;i++){
        printf("%d ",card[i]);
    }
    return 0;
}