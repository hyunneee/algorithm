from collections import deque
import sys
T = int(sys.stdin.readline())
for i in range(T):
    flip = False
    nonerror = True
    p = sys.stdin.readline()
    n = int(sys.stdin.readline())
    listn = sys.stdin.readline().strip()
    if n == 0: deq = deque()
    else: deq = deque(map(int,listn[1:-1].split(",")))
    
    for j in p:
        if j == 'R':
            flip = not flip
        elif (j == 'D'):
            if len(deq) <= 0:
                nonerror=False
                break
            if(not flip):
                deq.popleft()
            else:
                deq.pop()
    
    if (flip): deq.reverse()
    if(nonerror): print("["+",".join(map(str,deq))+"]")
    else: print("error")