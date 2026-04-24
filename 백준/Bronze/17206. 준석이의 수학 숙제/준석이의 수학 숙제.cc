#include<iostream>
using namespace std;
int arr[100001];
int main(void) {
    ios::sync_with_stdio(); cin.tie(NULL); cout.tie(NULL);
    int t,n;
    int sum=0;
    for(int i=3;i<=80000;i++){
        if(i%3==0||i%7==0)
            sum+=i;
        arr[i]=sum;}
    std::cin>>t;
    for(int i=0;i<t;i++){
        std::cin>>n;
        std::cout<<arr[n]<<'\n';
    }
    return 0;
}