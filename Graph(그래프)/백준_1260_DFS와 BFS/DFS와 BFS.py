from collections import deque

edge = []
for i in range(1001): edge.append([])
check = [False for _ in range(1001)]

def DFS(n):
    if check[n] == True:  return

    print(n, end=' ')
    check[n] = True
    for i in edge[n]:
        DFS(i)

def BFS(n):
    q = deque()
    q.append(n)
    check[n] = True

    while len(q) > 0:
        f = q.popleft()
        print(f, end=' ')
        for i in edge[f]:
            if check[i] == False:
                q.append(i)
                check[i] = True

N,M,v = map(int, input().split())

for i in range(M):
    a,b = map(int, input().split())
    edge[a].append(b)
    edge[b].append(a)

for i in range(N+1): edge[i].sort()
DFS(v)
print()
for i in range(N+1): check[i] = False
BFS(v)
