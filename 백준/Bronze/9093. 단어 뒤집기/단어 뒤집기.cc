#include<iostream>
#include<string>
using namespace std;
int t;
string str;
int main(void){
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    cin>>t;
    cin.ignore(); //버퍼 무시
    for(int i=0;i<t;i++){
        getline(cin,str); //라인입력
        for(int j=0;j<str.size();j++){
            if(str[j]==' '){
                for(int k=j-1;str[k]!=' '&&k>=0;k--)
                    cout<<str[k];
                cout<<" ";
            }
        }
        for(int j=str.size()-1;str[j]!=' '&&j>=0;j--)
            cout<<str[j];
        cout<<" \n";
    }}