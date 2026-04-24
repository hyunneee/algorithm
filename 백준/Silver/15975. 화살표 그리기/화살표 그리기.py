import sys
input = sys.stdin.readline

n=int(input())
num_list=[]

for i in range(n):
    x,y=map(int,input().split())
    num_list.append([y,x])
num_list.sort()
num_y=num_list[-1][0]
#print(num_list)
cnt=0
for i in range(n):
    l=sys.maxsize
    r=sys.maxsize
    if(i>=1):
        if(num_list[i-1][0]==num_list[i][0]):
            l=num_list[i][1]-num_list[i-1][1]
            #print("l",l)
    if(i+1<n):
        if(num_list[i+1][0]==num_list[i][0]):
            r=num_list[i+1][1]-num_list[i][1]
            #print("r",r)
    d=min(l,r)
    if(d!=sys.maxsize):
        cnt+=d
        #print("cnt",cnt)
    
print(cnt)