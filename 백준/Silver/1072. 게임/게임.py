import sys
input = sys.stdin.readline
x,y=map(int,input().split())
z=int((y*100/x))
if z>=99:
    print(-1)
else:
    start=1
    end=x
    cnt=0
    while start<=end:
        mid=(start+end)//2
        if(z>=((y+mid)*100//(x+mid))):
            start=mid+1
        else:
            end=mid-1
            cnt=mid        
    print(cnt)
