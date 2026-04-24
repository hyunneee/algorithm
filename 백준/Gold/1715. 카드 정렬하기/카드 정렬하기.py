import sys
import heapq

input = sys.stdin.readline
N = int(input())
hq = []
result = 0
for i in range(0, N):
    heapq.heappush(hq, int(input()))
while len(hq) > 1:
    num2 = heapq.heappop(hq)
    num1 = heapq.heappop(hq)
    result += num1 + num2
    heapq.heappush(hq, (num1 + num2))
print(result)
