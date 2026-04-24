# 입국심사
import sys

input = sys.stdin.readline
N, M = map(int, input().split(" "))
Tlist = [int(input()) for _ in range(N)]
left = min(Tlist)
right = M * min(Tlist)
while left <= right:
    mid = (left + right) // 2
    cnt = 0
    for sec in Tlist:
        cnt += mid // sec
    if cnt >= M:
        result = mid
        right = mid - 1
    else:
        left = mid + 1
print(result)
