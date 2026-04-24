arr=list()
final=list()
N,M=map(int,input().split())
arr=[list(input()) for _ in range(N)]
for col in range(N-7):
    for row in range(M-7):
        idxw=0
        idxb=0
        for i in range(col,col+8):
            for j in range(row,row+8):
                if(i+j)%2==0:
                    if(arr[i][j]!='W'):
                        idxw+=1
                    elif(arr[i][j]!='B'):
                        idxb+=1
                else:
                    if(arr[i][j]!='W'):
                        idxb+=1
                    elif(arr[i][j]!='B'):
                        idxw+=1
        final.append(idxw)
        final.append(idxb)
print(min(final))