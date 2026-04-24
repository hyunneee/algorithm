import sys
import heapq

heap = []
output = []
n = sys.stdin.readline()
for i in range(int(n)):
    t = int(input())
    if t == 0:
        if len(heap)==0:
            output.append("0")
        else:
            output.append(str(heapq.heappop(heap)[1]))
    else:
        heapq.heappush(heap,(-t,t))

print("\n".join(output))