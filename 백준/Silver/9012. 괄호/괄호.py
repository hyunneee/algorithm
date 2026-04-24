T = int(input())
for i in range(T):
    data=list()
    data = input()
    sum=0
    for j in data:
        if(j=="("):
            sum+=1
        elif(j==")"):
            sum-=1
        if(sum<0):
            print("NO")
            break
    if(sum==0):
        print("YES")
    elif(sum>0):
        print("NO")