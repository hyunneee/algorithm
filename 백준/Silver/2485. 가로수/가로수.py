def gcd(a,b):
    if(b>a):
        temp=a
        a=b
        b=temp
    while(b>0):
        temp=b
        b=a%b
        a=temp
    return a

num = int(input())
list=[]
list2=[]
a=0
for i in range(num):
    i=int(input())
    list.append(i)
list.sort()
for i in range(0,num-1):
    b=list[i+1]-list[i]
    #print(b)
    list2.append(b)
a=list2[0]
for i in range(0,len(list2)-1):
    b=list2[i+1]
    c=gcd(a,b)
    a=c
    #print(a)
sum=0
for i in range(0,len(list2)):
    #print(int(list2[i]/a)-1)
    sum+=(int(list2[i]/a)-1)
print(sum)
