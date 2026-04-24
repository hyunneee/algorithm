import sys

input = sys.stdin.readline

N, M = map(int, input().split(" "))


def is_possible(size):
    cnt = 1
    total = 0
    for lec in nlist:
        if total + lec > size:
            cnt += 1
            total = lec
        else:
            total += lec
    return cnt <= M


nlist = list(map(int, input().split(" ")))
start = max(nlist)
end = sum(nlist)
while start <= end:
    mid = (start + end) // 2
    if is_possible(mid):
        result = mid
        end = mid - 1
    else:
        start = mid + 1
print(result)
