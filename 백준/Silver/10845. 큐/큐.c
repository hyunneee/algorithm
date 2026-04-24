#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int queue[10001];
int front = 0;
int back = 0;
int queue_size = 0;


int empty(){
    if(queue_size == 0)
        return 1;
    return 0;
}

void push(int a){
    queue_size++;
    queue[back++] = a;
}

void pop(){
    if(empty()){
        printf("-1\n");
        // return -1;
    }
    else{
        queue_size--;
    // printf("front %d back %d\n",front+1,back);
        printf("%d\n",queue[front]);
        front++;
    }
}

int size(){
    // printf("%d\n",back-front+1);
    if(empty()){
        return 0;
    }
    return queue_size;
}


int Isfront(){
    // printf("%d\n",queue[front]);
    if(empty()){
        return -1;
    }
    return queue[front];
}

int Isback(){
    // printf("this is back\n");
    // printf("%d\n",queue[back]);
    if(empty()){
        return -1;
    }
    return queue[back-1];

}

int main(void){
    int n;
    scanf("%d ",&n);
    char order[5] = {0,};
    int m;
    int a;
    // printf("front %d back %d\n",front,back);
    for(int i=0;i<n;i++){
        scanf("%s",order);
        // fgets(order,10,stdin);
        // printf("order = %s %d\n",order,i);
        if(!strcmp(order,"push")){
            scanf("%d",&m);
            push(m);
        }
        else if(!strcmp(order,"pop")){
            // printf("m=%d\n",m);
            pop();
        }
        else if(!strcmp(order,"size")){
            // printf("m=%d\n",m);
            printf("%d\n",size());
        }
        else if(!strcmp(order,"front")){
            // printf("m=%d\n",m);
            printf("%d\n",Isfront());
        }
        else if(!strcmp(order,"back")){
            // printf("m=%d\n",m);
            printf("%d\n",Isback());
        }
        else if(!strcmp(order,"empty")){
            // printf("m=%d\n",m);
            printf("%d\n",empty());
        }
    }
    return 0;
}