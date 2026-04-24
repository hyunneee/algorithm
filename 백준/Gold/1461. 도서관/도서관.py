import sys
import heapq

input = sys.stdin.readline
N, M = map(int, input().split(" "))
qlist = sorted(list(map(int, input().split(" "))))
nq = sorted([x for x in qlist if x < 0], reverse=True)
pq = sorted([-x for x in qlist if x >= 0], reverse=True)

cost = 0
result = []
value = 0
while pq:
    if len(pq) >= 1:
        for i in range(0, M):
            if i == 0:
                cost = pq.pop()
            else:
                if len(pq) <= 0:
                    break
                pq.pop()
        heapq.heappush(result, abs(cost))

while nq:
    if len(nq) >= 1:
        for i in range(0, M):
            if i == 0:
                cost = nq.pop()
            else:
                if len(nq) <= 0:
                    break
                nq.pop()
        heapq.heappush(result, abs(cost))

while len(result) > 1:
    value += heapq.heappop(result) * 2
value += heapq.heappop(result)
print(value)
