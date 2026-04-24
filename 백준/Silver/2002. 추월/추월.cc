#include <iostream>
#include <string>
#include <map>
using namespace std;

int main(){

    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    map<string,int> incar;
    int outcar[1001];
    int n,i;
    int cnt=0;
    cin>>n;
    string car;
    for(i=0;i<n;i++){
        cin>>car;
        incar[car]=i;
    }
    for(i=0;i<n;i++){
        cin>>car; 
        int val = incar[car];
        outcar[i]=val;
     }

    for(int i=0;i<n-1;i++){
        for(int j=i+1;j<n;j++){
            if(outcar[i] > outcar[j]){ 
                    //추월했다.
                    cnt++;
                    break;
            }
        }
    }
    cout<<cnt;
    return 0;
}