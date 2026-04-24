import sys

input = sys.stdin.readline
T = int(input())
for _ in range(T):
    score_list = []
    N = int(input())
    score_list = [tuple(map(int, input().split(" "))) for _ in range(N)]
    score_list.sort(key=lambda x: x[0])
    count = 0
    best_interview = float("INF")
    for _, interview in score_list:
        if interview < best_interview:
            count += 1
            best_interview = interview
    print(count)
