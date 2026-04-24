#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    priority_queue<long long, vector<long long>,greater<long long> > pq;
    int n,m,val;
    long long result =0;
    cin>>n>>m;
    for(int i=0;i<n;i++){
        cin>>val;
        pq.push(val);
    }

    while(m--){
        long long x = pq.top();
        pq.pop();
        long long y = pq.top();
        pq.pop();
        pq.push(x+y);
        pq.push(x+y);
    }
    while(!pq.empty()){
        result+=pq.top();
        pq.pop();
    }
    cout<<result;
    return 0;

}