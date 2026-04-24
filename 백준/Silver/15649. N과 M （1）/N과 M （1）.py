
def func(arr,isused,k): #현재 k개까지 수를 택했음. 
    if k==m: #m개를 모두 택했으면
        for i in range(0,m): #arr에 기록해둔 수를 출력 
            print(arr[i]+1,end=' ')
        print("")
        return;
    for i in range(0,n): #1부터 n까지의 수에 대해
        if(isused[i]==True): #아직 i가 사용되지 않았으면
            arr[k]=i #k번째 수를 i로 정함 
            isused[i]=0 #i 사용됐다고 표시 
            func(arr,isused,k+1) #다음 수 정하기 
            isused[i]=1 #k번째 수를 i로 정한 모든 경우에 대해 다 확인했으니 i를 이제 사용되지 않았다고 표시
            

n,m=map(int,input().split()) #n,m 입력 
arr=[0]*m
isused=[True]*n
func(arr,isused,0)