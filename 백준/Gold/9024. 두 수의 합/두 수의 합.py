import sys

input = sys.stdin.readline
T = int(input())
for _ in range(T):
    N, K = map(int, input().split(" "))
    nlist = sorted(list(map(int, input().split(" "))))
    start = 0
    end = N - 1
    min_val = float("INF")
    cnt = 0
    while start < end:
        tmp = nlist[start] + nlist[end]
        if abs(K - tmp) < min_val:
            min_val = abs(K - tmp)
            cnt = 1
        elif abs(K - tmp) == min_val:
            cnt += 1

        if tmp < K:
            start += 1
        else:
            end -= 1
    print(cnt)
