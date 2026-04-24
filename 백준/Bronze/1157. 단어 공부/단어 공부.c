#include <stdio.h>
#include <string.h>

int main()
{
    char text[1000000];
    int num[26]={0,};
    int len;
    int max=num[0];
    int max_idx=0;
    int count=0;
    scanf("%s",text);
    len=strlen(text);

    for(int i='A';i<='Z';i++){
        for(int j=0;j<len;j++){
            if(i==text[j]){
                num[i-'A']++;
            }
        }
    }
    for(int i='a';i<='z';i++){
        for(int j=0;j<len;j++){
            if(i==text[j]){
                num[i-'a']++;
            }
        }
    }
    for(int i=0;i<26;i++){
        if(num[i]>max){
             max=num[i];
             max_idx=i;
            }
        }
    for(int i=0;i<26;i++){
        if(num[i]==max){
            count++;
        }
    }
    if(count>1)
       printf("?");
    else
        printf("%c", max_idx+'A');
        
    return 0;
}