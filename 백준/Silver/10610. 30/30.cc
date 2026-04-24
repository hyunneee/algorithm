#include<iostream>
#include<algorithm>
#include<string.h>
#include<vector>
using namespace std;

string n;
int N,temp;
vector<int> a;
bool compare(int i,int j){
    return i>j;
}

int main(void){
    ios::sync_with_stdio(); cin.tie(NULL); cout.tie(NULL);
    cin>>n;
    N=n.size();
    for(int i=0;i<N;i++){
        a.push_back(n[i]-'0');
        temp +=n[i]-'0';
    }
    sort(a.begin(),a.end(),compare);
    if(temp%3!=0||a[N-1]!=0){
        cout<<-1;
        return 0;}
    for(int i=0;i<N;i++){
        cout<<a[i];}
    return 0;
}