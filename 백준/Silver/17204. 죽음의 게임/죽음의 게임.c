#define _CRT_NO_SECURE_WARNINGS
#include <stdio.h>

int graph[151]={0};
int visited[151]={0};

int main(void){

    int n,k;
    scanf("%d %d",&n,&k);//참여자수, 보성이 번호
    //printf("%d %d",n,k);
    for(int i=0;i<n;i++){
        scanf("%d",&graph[i]);
        //printf("%d",node);
    }
    visited[0]=1;
    int next = graph[0];
    int i=1;
    for(;;){
        if(visited[next]){
            printf("-1\n");
            return 0;
        }
        else{
            if(next==k){
                printf("%d\n",i);
                return 0;
            }
            visited[next]=1;
            next=graph[next];
        }
        i++;
    }
    
    return 0;
}
