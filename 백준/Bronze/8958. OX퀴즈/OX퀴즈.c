#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

int main(void){
    int N;
    scanf("%d",&N);
    char arr[81];
    for(int i=0;i<N;i++){
        int count=0;
        int conti=0;
        scanf("%s",arr);
        for(int j=0;j<strlen(arr);j++){
            if(arr[j]=='O'){
                if(conti>0)
                    count+=conti;
                count++;
                conti++;
            }
            else
                conti=0;}
        printf("%d\n",count);
    }
    return 0;
}