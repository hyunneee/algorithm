n,h=map(int,input().split())
x=[0 for _ in range(h+1)]
y=[0 for _ in range(h+1)]
Px=[0 for _ in range(h+1)]
Py=[0 for _ in range(h+1)]
P=[0 for _ in range(h)]
for i in range(n//2):
    x[int(input())]+=1
    y[int(input())]+=1
Px[h]=x[h]
Py[1]=y[h]
for i in range(1,h):
    Px[h-i]=Px[h+1-i]+x[h-i]
    Py[i+1]=Py[i]+y[h-i]

for i in range(h):
    P[i]=Px[i+1]+Py[i+1]
min=min(P[:])
cnt=0
for i in P:
    if(i<min):
        min=i
        cnt=1
        
    elif(i==min):
        cnt+=1
      
print(min,cnt)