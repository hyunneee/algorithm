# 곱셈
import sys

input = sys.stdin.readline
A, B, C = map(int, input().split(" "))


def divide(b):
    if b == 1:
        return A % C
    half = divide(b // 2)
    if b % 2 == 0:  # 짝수
        return (half * half) % C
    else:
        return (half * half % C) * (A % C) % C


print(divide(B))
