# 감시 피하기
import sys
from itertools import combinations

input = sys.stdin.readline
N = int(input())
nlist = []
tlist = []
empty_list = []
for i in range(N):
    row = list(input().strip().split(" "))
    nlist.append(row)
    for j in range(N):
        if row[j] == "T":
            tlist.append((i, j))
        elif row[j] == "X":
            empty_list.append((i, j))
dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]
finished = False


def backtracking():
    for tx, ty in tlist:
        for dx, dy in dir:
            nx, ny = tx, ty
            while True:
                nx += dx
                ny += dy
                if nx < 0 or nx >= N or ny < 0 or ny >= N:
                    break
                if nlist[nx][ny] == "O":
                    break
                if nlist[nx][ny] == "S":
                    return False
    return True


for walls in combinations(empty_list, 3):
    # print(walls)
    for x, y in walls:
        nlist[x][y] = "O"

    if backtracking():
        finished = True
        print("YES")
        break

    for x, y in walls:
        nlist[x][y] = "X"
if not finished:
    print("NO")
