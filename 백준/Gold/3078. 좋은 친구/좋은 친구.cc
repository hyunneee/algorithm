#include<iostream>
#include<string>
#include<queue>
using namespace std;

string arr[300001];
int main(void) {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    int n,k;
    long long ans=0;
    queue<int> q[21];
    cin >> n >> k;
    for (int i = 1; i <= n; i++) {
        cin >> arr[i];
        int len=arr[i].length();
        while(!q[len].empty()&&i-q[len].front()>k)
            q[len].pop();
        ans+=q[len].size();
        q[len].push(i);}
    cout<<ans<<"\n";
   return 0;
}