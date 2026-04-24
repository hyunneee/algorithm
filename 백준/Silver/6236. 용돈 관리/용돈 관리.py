import sys

input = sys.stdin.readline
N, M = map(int, input().split(" "))
klist = []
for _ in range(N):
    klist.append(int(input()))
start = max(klist)
end = sum(klist)


def is_possible(sum):
    count = 1
    total = 0
    for money in klist:
        if total + money > sum:
            count += 1
            total = money
        else:
            total += money
    return count <= M


while start <= end:
    mid = (start + end) // 2
    if is_possible(mid):
        result = mid
        end = mid - 1
    else:
        start = mid + 1
print(result)
