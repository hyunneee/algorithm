# 레벨 햄버거
import sys

input = sys.stdin.readline
N, X = map(int, input().split(" "))
len = [1] * (N + 1)
patty = [1] * (N + 1)
for i in range(1, N + 1):
    len[i] = len[i - 1] * 2 + 3
    patty[i] = patty[i - 1] * 2 + 1


def search(n, x):
    if n == 0:
        return 0 if x <= 0 else 1
    if x == 1:
        return 0
    elif x <= 1 + len[n - 1]:
        return search(n - 1, x - 1)
    elif x == len[n - 1] + 2:
        return patty[n - 1] + 1
    elif x <= 1 + len[n - 1] + 1 + len[n - 1]:
        return patty[n - 1] + 1 + search(n - 1, x - (1 + len[n - 1] + 1))
    else:
        return patty[n]


print(search(N, X))
