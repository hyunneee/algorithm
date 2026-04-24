# 숨바꼭질 3
import sys
from collections import deque

input = sys.stdin.readline
N, K = map(int, input().split())
MAX = 100001
dist = [-1] * MAX

dq = deque()
dq.append(N)
dist[N] = 0

while dq:
    cur = dq.popleft()
    if cur == K:
        print(dist[cur])
        break
    # 순간이동
    if 0 <= cur * 2 < MAX and dist[cur * 2] == -1:
        dist[cur * 2] = dist[cur]
        dq.appendleft(cur * 2)
    # -1
    if 0 <= cur - 1 < MAX and dist[cur - 1] == -1:
        dist[cur - 1] = dist[cur] + 1
        dq.append(cur - 1)
    # +1
    if 0 <= cur + 1 < MAX and dist[cur + 1] == -1:
        dist[cur + 1] = dist[cur] + 1
        dq.append(cur + 1)
