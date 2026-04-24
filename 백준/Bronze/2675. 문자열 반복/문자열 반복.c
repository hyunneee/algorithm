#include<stdio.h>
#include<string.h>

int main(void){
    int t;
    scanf("%d",&t);
    for(int i=0;i<t;i++){
        int r;
        char str[21];
        scanf("%d %s",&r,str);
        for(int i=0;i<strlen(str);i++){
            for(int j=0;j<r;j++){
                printf("%c",str[i]);
            }
        }
        printf("\n");
    }
    return 0;
}