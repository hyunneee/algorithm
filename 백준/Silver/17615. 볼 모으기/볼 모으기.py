# 볼 모으기
import sys

input = sys.stdin.readline
N = int(input())
ball = list(input().strip())


def forloop(color, dir):
    cnt = 0
    if dir == 1:
        for i in ball:
            if i == color:
                cnt += 1
            else:
                break
    else:
        for i in reversed(ball):
            if i == color:
                cnt += 1
            else:
                break
    return cnt


red_total = ball.count("R")
blue_total = ball.count("B")

moves = [
    red_total - forloop("R", 1),
    red_total - forloop("R", -1),
    blue_total - forloop("B", 1),
    blue_total - forloop("B", -1),
]
print(min(moves))
