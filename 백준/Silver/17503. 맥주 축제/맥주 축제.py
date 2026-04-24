import sys
import heapq

input = sys.stdin.readline
N, M, K = map(int, input().split(" "))
s = []
for k in range(K):
    v, c = map(int, input().split(" "))
    s.append((c, -v))
s = sorted(s, reverse=True)

vlist = []
sum_v = 0
while len(vlist) <= N:
    if len(s) <= 0:
        break
    c, v = s.pop(-1)
    heapq.heappush(vlist, (-v, c))
    sum_v -= v
    if len(vlist) == N:
        if sum_v >= M:
            break
        else:
            v, c = heapq.heappop(vlist)
            sum_v -= v
if len(vlist) > N or sum_v < M:
    print("-1")
else:
    max_c = max([c for v, c in vlist])
    print(max_c)
