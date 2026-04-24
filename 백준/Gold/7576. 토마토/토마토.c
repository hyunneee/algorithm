#include <stdio.h>

int tomato[1005][1005];
int check[1005][1005] = {0,};
int queue[1000050][2];
int head = 0, tail = 0;
int dx[4] = {0,0,-1,1};
int dy[4] = {-1,1,0,0};

int x,y;

int main(void){

    int m,n;
    // m, n 불러오기
    scanf("%d %d",&m,&n);

    // tomato 초기화해주기
    for(int i=0;i<n+1;i++){
        for(int j=0;j<m+1;j++){
            tomato[i][j] = -1;
        }
    }
    
    // tomato 저장 & tomato 있으면 q에 저장해주기
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            scanf(" %d",&tomato[i][j]);
            if(tomato[i][j] == 1){
                queue[tail][0] = i;
                queue[tail][1] = j;
                tail++;
            }
        }
    }

    while(head < tail){
        x = queue[head][0];
        y = queue[head][1];
        // printf("%d %d\n",x,y);
        head++;
        for(int i=0;i<4;i++){
            while(x+dx[i]>=1 && x+dx[i] <= n && y+dy[i] >=1 && y+dy[i] <= m && tomato[x+dx[i]][y+dy[i]] == 0){
                tomato[x+dx[i]][y+dy[i]] = 1;
                check[x+dx[i]][y+dy[i]] = check[x][y] + 1;
                queue[tail][0] = x + dx[i]; //꼬리에 상하좌우 큐에 넣어주기ㅠ....를 안하니까 안되지!
                queue[tail][1] = y + dy[i];
                tail++;
            }
        }
    }
    
    int days = 0;
    int cnt = 0;

    for(int i = 1; i<=n; i++){
        for(int j=1;j<=m;j++){
            if(days < check[i][j])
                days = check[i][j];
            if(tomato[i][j] == 0){
                cnt = 1;

            }
        }
    }
    if(cnt==1)
        printf("-1\n");
    else   
        printf("%d\n",days);
    
    return 0;
}

