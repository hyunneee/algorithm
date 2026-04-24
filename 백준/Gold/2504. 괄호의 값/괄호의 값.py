string = list(input())
stack=[]
result=0
temp=1
for i in range(len(string)):

    if(string[i]=='('):
        stack.append('(')
        temp*=2
    elif(string[i]=='['):
        stack.append('[')
        temp*=3

    elif(string[i]==')'):
        if(len(stack)==0 or stack[-1]=='['):
            result=0
            break
        if(string[i-1]=='('):
            
            result+=temp
        stack.pop()
        temp//=2
        

    elif(string[i]==']'):
        if(len(stack)==0 or stack[-1]=='('):
            result=0
            break
        if(string[i-1]=='['):
             result+=temp
        stack.pop()
        temp//=3
        
if stack:
    print(0)
else:
    print(result)