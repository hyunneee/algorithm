#define _CRT_NO_SECURE_WARNINGS
#include <stdio.h>

int graph[101][101]={0};
int visited[101]={0};
int cnt=0;

void dfs(int v,int n){
    int i;
    visited[v]=1;
    for(int i=1;i<=n;i++){
        if(graph[v][i]==1 && visited[i]==0){
            dfs(i,n);
            cnt++;
        }
    }
    return;
}

int main(void){

    int n,m;
    scanf("%d",&n); //컴퓨터 수
    scanf("%d",&m); //컴퓨터 쌍 개수
    //printf("%d %d\n",n,m);
    for(int i=0;i<m;i++){ //컴퓨터 쌍 입력받기
        int node1,node2;
        scanf("%d %d",&node1,&node2);
        graph[node1][node2]=1;
        graph[node2][node1]=1;
        //printf("%d %d\n",node1,node2);

    }

    dfs(1,n);
    
    printf("%d",cnt);
    return 0;
}