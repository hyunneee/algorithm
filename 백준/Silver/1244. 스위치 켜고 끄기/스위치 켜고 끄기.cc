#include <iostream>
using namespace std;

int main(){
    int num;
    cin >> num;
    
    int* arr = new int[num];
    for (int i=0;i<num;i++){
        cin >> arr[i];
    }

    int people;
    cin >> people;

    for (int i=0;i<people;i++){
        int gender, start;
        cin >> gender >> start;
        switch(gender){
            case 1:
                // cout << "남성" << "\n";
                for(int j=start;j<=num;j+=start){
                    arr[j-1] = 1 - arr[j-1];
                }
                // cout << "변경 후 - 남성" << "\n";
                // for (int k=0;k<num;k++){
                //     cout << arr[k];
                // }
                break;
            case 2:
                // cout << "여성" << "\n";
                arr[start-1] = 1-arr[start-1];
                for(int j=1;j<num;j++){
                    if (start-1-j < 0 || start-1+j >= num){
                        break;
                    }
                    if(arr[start-1-j] == arr[start-1+j]){
                        arr[start-1-j] = 1 - arr[start-1-j];
                        arr[start-1+j] = 1 - arr[start-1+j];
                    }
                    else {
                        break;
                    }
                }
                // cout << "변경 후 - 여성" << "\n";
                // for (int k=0;k<num;k++){
                //     cout << arr[k];
                // }
                break;
            default:
                // cout << "default" << "\n";
                break;
        }
    }
    for (int k=0;k<num;k++){
        cout << arr[k];
        if((k+1)%20 == 0 || k == num-1) cout << "\n";
        else cout << ' ';
    }

    delete[] arr;                
    return 0;
}