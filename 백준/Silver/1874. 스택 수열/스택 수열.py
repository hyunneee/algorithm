n = int(input())
arr = []
for i in range(0,n):
    arr.append(int(input()))
stack = []
result = []
curr = 1
possible= True

for num in arr:
    while (curr<=num):
        stack.append(curr)
        result.append("+")
        curr+=1

    if (stack[-1] == num):
        stack.pop()
        result.append("-")
    else:
        possible = False
        break

if possible:
    for r in result:
        print(r)
else:
    print("NO")