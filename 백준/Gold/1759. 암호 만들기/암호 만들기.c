#include <stdio.h>
#include <stdlib.h>


int l,c;
char pw[15];
char ans[15];
int visited[15];

int compare(const void* a,const void* b){
    if (*(char*)a>*(char*)b)
        return 1;
    else
        return -1;
}
void dfs(int depth,int start);

int main(void){

    scanf("%d %d",&l,&c);
    // printf("%d %d\n",l,c);
    for(int i = 0;i<c;i++){
        scanf(" %c",&pw[i]);
    }
    // for(int i = 0;i<c;i++){
    //     printf("%c ",pw[i]);
    // }
    // printf("\n");
    qsort(pw,c,sizeof(char), compare);
    // for(int i = 0;i<c;i++){
    //     printf("%c ",pw[i]);
    // }
    // printf("\n");
    dfs(0,0);

    return 0;
}

void dfs(int depth,int start){
    // printf("%d %d\n",depth,start);
    if (depth == l){
        int mo_len = 0, ja_len = 0;
        for(int i=0;i<depth;i++){
            if(ans[i] == 'a' || ans[i] == 'e' || ans[i] == 'i' || ans[i] == 'o' || ans[i] == 'u' )
                mo_len++;
            else
                ja_len++;
        }
        if(mo_len > 0 && ja_len > 1){
            for(int i=0;i<l;i++){
                printf("%c",ans[i]);
            }
            printf("\n");
        }
        else
            return;
    }
    
    for(int i = start; i<c; i++){
        if(!visited[i]){
            visited[i] = 1;
            ans[depth] = pw[i];
            dfs(depth+1,i+1);
            visited[i] = 0;
        }    
    }

}