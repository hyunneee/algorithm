#include<iostream>
#include<vector>
using namespace std;

int arr[1001];
int main(){
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    int n, idx;
    int max_idx = 0, max_height_idx = 0, min_idx = 0;
    cin>>n;
    for(int i=0;i<n;i++){
        cin>>idx>>arr[idx];
        min_idx=min(min_idx,idx);
        max_idx=max(max_idx,idx);
        if(arr[idx]>arr[max_height_idx]){
            max_height_idx=idx;
        }
    }
    int ans=arr[max_height_idx];
    int sum=0,h=0;
    for(int i=min_idx;i<max_height_idx;i++){
        h=max(h,arr[i]);
        sum+=h;
    }
    h=0;
    for(int i=max_idx;i>max_height_idx;i--){
        h=max(h,arr[i]);
        sum+=h;
    }
    cout<<ans+sum;
}