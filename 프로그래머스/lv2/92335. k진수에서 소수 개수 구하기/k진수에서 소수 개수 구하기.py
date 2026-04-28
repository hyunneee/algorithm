primelist = []
    
def isPrime(s):
    if s<2:
        return False
    i = 2
    while (i*i) <= s:
        if s%i==0:
            return False
        i+=1  
    return True

def solution(n, k):
    answer = 0
    s = ''
    while n:
        s = str(n%k) + s
        n = n//k
    slist = s.split("0")
    for s in slist:
        if s == '':
            continue
        print(s)
        if isPrime(int(s)):
            # print(s,"is Prime")
            answer +=1 
    
    return answer