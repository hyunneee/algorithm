# 회의실 배정
import sys

input = sys.stdin.readline
N = int(input())
schedule = []
for _ in range(N):
    sp, ep = map(int, input().split(" "))
    schedule.append([sp, ep])
schedule.sort(key=lambda x: (x[1],x[0]))
s_p = float("INF")
e_p = float("-INF")
count = 0
for sp_i, ep_i in schedule:
    if e_p <= sp_i:
        e_p = ep_i
        count += 1
print(count)
