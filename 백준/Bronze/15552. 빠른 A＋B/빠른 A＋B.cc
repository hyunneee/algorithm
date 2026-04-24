#include<iostream>
using namespace std;
int main(void) {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    int num;
    int a=0,b=0;
    std::cin>>num;
    for(int i=0;i<num;i++){
        std::cin>>a>>b;
        std::cout<<a+b<<'\n';
    }
}