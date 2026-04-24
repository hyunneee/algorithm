#include<stdio.h>

int main(void){
    int user[9];
    int a = -1, d = -1;
    for(int i=0;i<8;i++){
        scanf("%d",&user[i]);
    }
    for(int i=0;i<8;i++){
        if(user[i] != i+1){
            a = 0;
            break;
        }
    }
    for(int i=0;i<8;i++){
        if(user[i] != 8-i){
            d = 0;
            break;
        }
    }
    if(a == 0 && d == 0){
        printf("mixed\n");
    }
    else if(a == -1){
        printf("ascending\n");
    }
    else{
        printf("descending\n");
    }

    return 0;
}