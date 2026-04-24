#include<iostream>
#include<algorithm>
#include<vector>
#include<tuple>
using namespace std;

struct person{
    string name;
    int kor,eng,math;
};

bool compare(const struct person &v, const person &u){
    if(v.kor>u.kor)
        return true;
    else if(v.kor==u.kor){
        if(v.eng<u.eng)
            return true;
        else if(v.eng==u.eng){
            if(v.math>u.math)
                return true;
            else if(v.math==u.math){
                if(v.name<u.name)
                    return true;
            }}}
    return 0;
}

int main(void){
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    int n;
    cin>>n;
    vector<person> v(n);
    for(int i=0;i<n;i++){
        cin >> v[i].name >> v[i].kor >> v[i].eng >> v[i].math;
    }
    sort(v.begin(),v.end(),compare);
    for(int i=0;i<n;i++){
        cout<<v[i].name<<"\n";
    }
    return 0;
}
