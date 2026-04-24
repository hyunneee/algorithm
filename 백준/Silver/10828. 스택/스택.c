#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>

int arr[100001];

int main(){
    int n=0,c;
    char input[10];
    int tmp=0;
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        scanf("%s",input);
        if(!strcmp(input,"push")){
            scanf("%d",&c);
            arr[tmp]=c;
            tmp++;
          
        }
        else if(!strcmp(input,"pop")){
            if(tmp==0){
                printf("%d\n",-1);
            }
            else{
                tmp--;
                printf("%d\n",arr[tmp]);
                arr[tmp]=0;
                }
        }
        else if(!strcmp(input,"size")){
            printf("%d\n",tmp);
        }
        else if(!strcmp(input,"empty")){
            if(tmp!=0){
                printf("%d\n",0);
            }
            else
                printf("%d\n",1);
        }
        else if(!strcmp(input,"top")){
            if(tmp==0)
                printf("%d\n",-1);
            else
                printf("%d\n",arr[tmp-1]);
        }
    }
    return 0;
}