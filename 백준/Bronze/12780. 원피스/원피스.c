#include<stdio.h>
#include<string.h>
char h[100001];
int main(void){
    char n[10];
    int num=0;
    scanf("%s",h);
    scanf("%s",n);
    char *ptr=strstr(h,n);
    while(ptr!=NULL){
        num++;
        ptr=strstr(ptr+1,n);}
    printf("%d",num);
    return 0;
}
