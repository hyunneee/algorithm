#include <stdio.h>
#include <string.h>

char stack[100]={0,};
int j=-1;
 
int main(void){
    char arr[100]={0,};
    while(1){
        j=-1;
        fgets(arr,102,stdin);
        arr[strlen(arr)-1]='\0';
        if(strcmp(arr,".")==0){
            break;
        }
        for(int i=0;i<strlen(arr);i++){
            if(arr[i]=='('||arr[i]=='['||arr[i]==')'||arr[i]==']'){
                if(j==-1){
                        stack[++j]=arr[i];}
                else{
                    if(stack[j]=='('&&arr[i]==')'){
                        if(j<0)
                            return -1;
                        else
                            stack[j--]='\0';
                    }
                    else if(stack[j]=='['&&arr[i]==']'){
                            if(j<0)
                                return -1;
                            else
                                stack[j--]='\0';}
                    else{
                            if(j>=101)
                            return -1;
                        else
                            stack[++j]=arr[i];}
                    }
            }
        }
            if(j==-1){
                printf("yes\n");
            }
            else{
                printf("no\n");
            }
        }
        return 0;
}
