import sys
input = sys.stdin.readline

def func(nums,isused,k): #현재 k개까지 수를 택했음. 
    if len(k)==6: #6개를 모두 택했으면
        for i in range(6): #nums에 기록해둔 수를 출력 
            print(nums[k[i]],end=' ') 
        print()
        return;
    t_isused=isused[:] 
    for i in range(len(t_isused)):
        if(t_isused[i]==False):
            t_isused[i]=True 
            func(nums,t_isused,k+[i]) 

while(1):
    nums=list(map(int,input().split())) #k,s
    if nums[0]==0: #0 나오면 반복 종료 
        break;
    k=nums.pop(0) #k 분리해주기 
    isused=[False]*len(nums) #false로 초기화 
    func(nums,isused,[])
    print()
