#include <iostream>
#include <string>
#include <set>
using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    int t;
    cin>>t;
    while(t--){
        int k;
        cin>>k;
        multiset<long long> ms;
        for(int i=0;i<k;i++){
            
            char c;
            long long num;
            cin>>c>>num;

            switch(c){
                case 'I':
                    ms.insert(num);
                    break;
                
                case 'D':
                    if(!ms.size())
                        break;
                    if(num==1){ //최댓값
                        ms.erase(--ms.end());
                    }
                    else{ //최솟값
                        ms.erase(ms.begin());
                    }
                    break;
            }
        }
        if(ms.size()){
            cout<<*(--ms.end())<<" "<<*ms.begin()<<"\n";
        }
        else{
            cout<<"EMPTY\n";
        }
    }
}