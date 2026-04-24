#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int main(void){
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    int n;
    int max=0;
    cin>>n;
    vector<vector<int>> v(n,vector<int>(2,0));
    vector<int> idx(n);
    vector<int> afteridx(n);
    for(int i=0;i<n;i++){
        cin>>v[i][0];
        v[i][1]=i;
    }
    sort(v.begin(),v.end());
    for(int i=0;i<v.size();i++){
        v[i][1]-=i;
        if(v[i][1]>max)
            max=v[i][1];
    }
    cout<<max+1;
    return 0;
}
