from collections import deque

n,m=map(int,input().split())
do=deque()
su=deque()

for _ in range(n):
    a,b=map(int,input().split())
    do.append(a)
    su.append(b)

tmp1=0
tmp2=0

do_g=deque()
su_g=deque()

for m in range(m):
    if(m%2==0):
        tmp1=do.pop()
        do_g.append(tmp1)
    else:
        tmp2=su.pop()
        su_g.append(tmp2) 
    if(len(do)==0):
        break
    elif(len(su)==0):
        break
    if(tmp1+tmp2==5) and (tmp1!=0) and (tmp2!=0):
        while do_g:
            su.extendleft(do_g)
            tmp1=0
            do_g=deque()

        while su_g:
            su.extendleft(su_g)
            tmp2=0
            su_g=deque()
            
    elif(tmp1==5) or (tmp2==5):
        while su_g:
            do.extendleft(su_g)
            tmp2=0
            su_g=deque()
        while do_g:
            do.extendleft(do_g)
            tmp1=0
            do_g=deque() 
            
if(len(do)>len(su)):
    print("do")
elif(len(do)<len(su)):
    print("su")
else:
    print("dosu")