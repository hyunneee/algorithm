#include <stdio.h>

int main(void){
    int n;
    int srt=1,end=7,i=1;
    scanf("%d",&n);
    while(1){
    if(n==1){
        printf("1");
        break;
    }
    else if(srt<n&&n<=end){
        printf("%d",i+1);
        break;
    }
    else{
        srt=srt+6*i;
        end=end+6*i+6;
        i++;
        }
    }
    return 0;
}