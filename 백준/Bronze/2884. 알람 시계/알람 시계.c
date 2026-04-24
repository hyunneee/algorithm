#include <stdio.h>

int main()
{
    int H,M;
    scanf("%d %d",&H,&M);
    if(M-45<0){
        if(H==0)
            H=23;
        else{
            H-=1;
        }
        M=60+(M-45);
    }
    else
       M-=45;
    
    printf("%d %d",H,M);

    return 0;
}