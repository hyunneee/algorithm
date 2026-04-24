#include<iostream>
using namespace std;

int arr[1048577];
int tmp[1048577];
int n,k;

void merge_sort(int l,int r);
void merge(int l,int r);

int main(void){
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    cin>>n; //치킨집 개수
    for(int i=0;i<n;i++)
        cin>>arr[i]; //치킨맛 수치를 배열에 저장
    cin>>k; //사람 수
    merge_sort(0,n-1);
    for(int i=0;i<n;i++){
        cout<<arr[i]<<' ';
    }
    return 0;
}
void merge(int l,int r){
    if(r-l>n/k) return;
    int m=(l+r)/2;
    int idx1,idx2,idx3;
    idx1=l; idx3=0; idx2=m+1;
    while(idx1<=m && idx2<=r){
        if(arr[idx1]>arr[idx2]) tmp[idx3++]=arr[idx2++];
        else                    tmp[idx3++]=arr[idx1++];
    }
    while(idx1<=m) tmp[idx3++]=arr[idx1++];
    while(idx2<=r) tmp[idx3++]=arr[idx2++];
    for(int i=l;i<=r;i++)   arr[i]=tmp[i-l];
}
void merge_sort(int l,int r){
    if(l==r) return;
    int m=(l+r)/2;
    merge_sort(l,m);
    merge_sort(m+1,r);
    merge(l,r);
}
