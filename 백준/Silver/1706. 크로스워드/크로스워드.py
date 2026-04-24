arr = []
R, C = map(int, input().split(" "))
for i in range(0, R):
    arr.append(input())
start = 0
alpha = "z" * max(R, C)
# print("alpha", alpha)
for i in range(0, R):
    start = 0
    for j in range(0, C + 1):
        if j == C or arr[i][j] == "#":
            if j - start >= 2:
                word = arr[i][start:j]
                if word < alpha:
                    alpha = word
            start = j + 1

for j in range(0, C):
    start = 0
    for i in range(0, R + 1):
        if i == R or arr[i][j] == "#":
            if i - start >= 2:
                temp = "".join([arr[k][j] for k in range(start, i)])
                if temp < alpha:
                    alpha = temp
            start = i + 1
            # print("alpha updated", alpha)
print(alpha)
