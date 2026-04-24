from collections import deque

def dfs(graph,root): #dfs
    visited=[] #방문 확인 
    stack=[root] #(root=시작하는 번호)부터 시작 

    while stack:
        n=stack.pop()
        if n not in visited: #스택에서 빼준 값이 visited에 없으면
            visited.append(n) #visited에 추가해주기 
            if n in graph: #n이 그래프에 있으면 
                temp=list(set(graph[n])-set(visited)) #graph-visited(방문 안한 child-node)
                temp.sort(reverse=True) #정렬 
                stack+=temp #스택에 넣어주기 
    return " ".join(str(i) for i in visited) #visited 순서대로 문자열 만들어서 반환 


def bfs(graph,root): #bfs
    visited=[]
    queue=deque([root]) #(root=시작하는 번호)부터 시작 

    while queue:
        n= queue.popleft()
        if n not in visited: #큐에서 빼준 값이 visited에 없으면
            visited.append(n) #visited에 추가해주기
            if n in graph: #n이 그래프에 있으면 
                temp=list(set(graph[n])-set(visited)) #graph-visited(방문 안한 child-node)
                temp.sort() #정렬 
                queue+=temp #큐에 넣어주기 
    return " ".join(str(i) for i in visited) #visited 순서대로 문자열 만들어서 반환 

graph={}
n,m,v=map(int,input().split())
for _ in range(m): 
    n1,n2= map(int,input().split()) #연결된 node m개 입력받기// 양방향 node 연결해주기 
    if n1 not in graph: #graph에 n1이 없으면 n1에 n2(child-node) 넣어주기 
        graph[n1]=[n2]
        #print(graph)
    elif n2 not in graph[n1]: #graph에 n1이 있는데, n2(즉, 새로운 child-node)가 없으면
        graph[n1].append(n2) #graph[n1]에 n2넣어주
        #print(graph)

    if n2 not in graph: #graph에 n2이 없으면 n2에 n1(child-node) 넣어주기 
        graph[n2]=[n1]
        #print(graph)
    elif n1 not in graph[n2]: #graph에 n2이 있는데, n1(즉, 새로운 child-node)가 없으면
        graph[n2].append(n1) #graph[n2]에 n1넣어주기 
        #print(graph)

print(dfs(graph,v))
print(bfs(graph,v))