#include <stdio.h>
#include <string.h>

int main(void){
    int k; //테스트 개수
    scanf("%d",&k);
    
    for(int i=0;i<k;i++){
        int n,result=1; //총 옷 개수 n, 구하고자하는 날
        scanf("%d",&n); //총 의상 개수
        int cloth_kind=0; //옷 종류 개수
        char name[21]; //이름 문자열
        char kind[21]; //종류 문자열
        char list[31][21]; //종류 문자열 정리할 배열
        int each_kind_num[31]; //각 종류별 의상 개수
        for(int j=0;j<n;j++){ //총 개수만큼 반복문
            scanf("%s %s", name,kind);
            int l;
            for(l=0;l<cloth_kind;l++){
                int ret=strcmp(kind,list[l]); //입력받은 kind가 list에 있는지
                if(ret==0){
                    each_kind_num[l]++; //있으면 해당 종류의 의상 개수 늘림
                    break;
                }
            }
            if(l==cloth_kind){ //새로 나온 의상이다
                strcpy(list[cloth_kind],kind); //list에 추가해줌
                each_kind_num[cloth_kind]=1; //해당 종류의 의상 개수 1개
                cloth_kind++;
            }
        }
        for(int p=0;p<cloth_kind;p++){ //의상 개수 곱해서 조합구하기
            result*=(each_kind_num[p]+1);}
        printf("%d\n",result-1);
    }
    return 0;
}