# 센서
import sys

input = sys.stdin.readline
N = int(input())
K = int(input())
nlist = sorted(list(map(int, input().split(" "))))
diffs = sorted([nlist[i + 1] - nlist[i] for i in range(N - 1)], reverse=True)
total_length = nlist[-1] - nlist[0]
print(total_length - sum(diffs[: K - 1]))
