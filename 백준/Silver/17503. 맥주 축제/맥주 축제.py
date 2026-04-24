import sys
import heapq
input = sys.stdin.readline

n,m,k = map(int,input().split())

beerl = []
pq = []
heapq.heapify(pq)
for _ in range(k):
    v,c = map(int,input().split())
    beerl.append((v,c))
beerl.sort(key=lambda x:(x[1],x[0])) #도수레벨 -> 선호도 작은 
find = False
now_al = 0
sum = 0
for i in range(k):
    heapq.heappush(pq,beerl[i][0])
    sum+=beerl[i][0]
    now_al = beerl[i][1]
    if len(pq) == n:
        if sum>= m:
            find = True
            print(now_al)
            break
        else:
            sum -= heapq.heappop(pq)
if not find:
    print(-1)