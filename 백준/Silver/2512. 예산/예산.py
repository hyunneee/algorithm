import sys
input = sys.stdin.readline
n=int(input())
arr=list(map(int,(input().split())))
m=int(input())
start=0
end=max(arr)
while start<=end:
    mid=(start+end)//2
    cnt=0
    for i in arr:
        if i>mid:
            cnt+=mid
        else:
            cnt+=i
    if cnt<=m:
        start=mid+1
    else:
        end=mid-1
print(end)
