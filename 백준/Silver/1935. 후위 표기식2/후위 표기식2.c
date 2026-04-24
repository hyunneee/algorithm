#include <stdio.h>
#include <string.h>

int main(){
    int n;
    scanf("%d",&n);
    
    char str[101];
    scanf("%s",str);

    double stack[101]; int cnt=-1;
    double arr[26];
    
    for(int i=0;i<n;i++){
        scanf("%lf",&arr[i]);
    }
    double len=strlen(str);
    double num1=0,num2=0;
    
    for(int i=0;i<len;i++){
        char ch = str[i];
        if(ch>='A'&& ch<='Z'){
            cnt++;
            stack[cnt]=arr[ch-'A'];
        }
        else{
            num1=stack[cnt];
            cnt--;
            num2=stack[cnt];
            if(str[i]=='+'){
                stack[cnt]=(num2+num1);
            }
            else if(str[i]=='-'){
                stack[cnt]=(num2-num1);
            }
            else if(str[i]=='*'){
               
                stack[cnt]=(num2*num1);
            }
            else if(str[i]=='/'){
                stack[cnt]=(num2/num1);
            }
        }
    }
    printf("%.2f\n",stack[cnt]);
    return 0;
}
