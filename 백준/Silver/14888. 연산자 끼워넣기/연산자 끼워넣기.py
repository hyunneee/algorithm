# 연산자 끼워넣기
import sys

input = sys.stdin.readline
N = int(input())
num = list(map(int, input().split(" ")))
plus, minus, mul, div = list(map(int, input().split(" ")))
min_val = float("INF")
max_val = float("-INF")


def dfs(idx, val, plus, minus, mul, div):
    global max_val, min_val
    if idx == N:
        max_val = max(max_val, val)
        min_val = min(min_val, val)
        return
    if plus:
        dfs(idx + 1, val + num[idx], plus - 1, minus, mul, div)
    if minus:
        dfs(idx + 1, val - num[idx], plus, minus - 1, mul, div)
    if mul:
        dfs(idx + 1, val * num[idx], plus, minus, mul - 1, div)
    if div:
        if val < 0:
            dfs(idx + 1, -(-val // num[idx]), plus, minus, mul, div - 1)
        else:
            dfs(idx + 1, val // num[idx], plus, minus, mul, div - 1)


dfs(1, num[0], plus, minus, mul, div)
print(max_val)
print(min_val)
