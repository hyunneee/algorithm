n = int(input())
cur = list(map(int, input()))
tgt = list(map(int, input()))

def change(N,M):
    L = N[:]
    cnt = 0
    for i in range(1,n):
        if L[i-1] == M[i-1]:
            continue
        cnt+=1
        for j in range(i-1,min(i+2,n)):
            L[j]=1-L[j]
    return cnt if L ==  M else 100001

res = change(cur,tgt)
cur[0] = 1- cur[0]
cur[1] = 1- cur[1]
res = min(res,change(cur,tgt)+1)
print(res if res != 100001 else "-1")
