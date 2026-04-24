n=int(input())
A=list(map(int,input().split()))
stack=[]
stack.append(0)
nge=[-1]*n
for i in range(1,n):
    while stack and A[stack[-1]]<A[i]:
        nge[stack.pop()]=A[i]
    stack.append(i)
print(*nge)