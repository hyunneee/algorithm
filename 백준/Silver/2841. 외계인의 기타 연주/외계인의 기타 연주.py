n,p=map(int,input().split())

a=[list(map(int,input().split())) for i in range(n)]
    
cnt=0
stack=[[] for i in range(7)]

for j,p in a:
    if(len(stack[j])==0):
        stack[j].append(p)
        cnt+=1
    else:
        if(stack[j][-1]<p):
            stack[j].append(p)
            cnt+=1
        elif(stack[j][-1]>p):
            while(len(stack[j])!=0) and (stack[j][-1]>p):
                stack[j].pop()
                cnt+=1
            if len(stack[j])!=0 and stack[j][-1]==p:
                   continue
            stack[j].append(p)
            cnt+=1
print(cnt)
