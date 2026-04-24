import sys
input=sys.stdin.readline
n,c=map(int,input().split()) #n과 c 입력
nlist=[] #n개의 좌표 입력받을 배열 
for i in range(n):
    nlist.append(int(input())) #좌표 입력 
nlist.sort() #sort

start=1
end=nlist[-1]-nlist[0] #최대 거리 
ans=0
while(start<=end):
    mid=(start+end)//2 
    cur=nlist[0] #공유기 세 위치 
    cnt=1 #공유기 세운 개수 
    for i in range(n):
        if nlist[i]>=cur+mid: #(공유기 설치장소에서 중간값 더한 값)보다 더 크면
            cnt+=1 #공유기 설치해주기 
            cur=nlist[i] #공유기 설치 장소 갱신 
    if(cnt>=c): #공유기 개수가 할당된 c보다 크면 개수 줄여줘야하므로
        start=mid+1
        ans=mid
    else: #공유기 개수가 할당된 c보다 작으면 개수 늘려야하므
        end=mid-1
print(ans)
