import sys
cnt = 1
while(True):
    stack = []
    val = 0
    str = sys.stdin.readline()
    if '-' in str:
        break
    for i in str:
        if (i=="{"):
            stack.append(i)
        elif (i=="}"):
            if len(stack) <= 0:
                val+=1
                stack.append("{")
                continue
            j = stack[-1]
            if (j=="{"):
                stack.pop()
            else:
                stack.append(i)
        else:
            break
    if (len(stack) > 0):
        val +=(len(stack)//2)
    print(f"{cnt}. {val}")
    cnt+=1