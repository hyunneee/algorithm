#include <stdio.h>
int front=-1;
int rear=-1;
int queue[500000];

void addq(int value){
        rear=(rear+1)%500000;
        queue[rear]=value;
}

int main(){
    int N;
    scanf("%d",&N);
    for(int i=1;i<=N;i++){
        addq(i);
    }
    while(1){
        if(front+1==rear){
            break;
        }
        front=(front+1)%500000;
        addq(queue[front+1]);
        front=(front+1)%500000;
    }
    printf("%d",queue[front+1]);
    return 0;
}
