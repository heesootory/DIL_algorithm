from collections import deque

check = [False for _ in range(100001)]
parent_node = [0 for _ in range(100001)]
edge = [[] for _ in range(100001)]
q = deque()

def BFS(n):
    q.append(n)
    check[n] = True
    while len(q) > 0:
        f = q.popleft()
        for i in edge[f]:
            if check[i] == False:
                check[i] = True
                parent_node[i] = f
                q.append(i)

N = int(input())
M = N-1
for _ in range(M):
    a,b = map(int, input().split())
    edge[a].append(b)
    edge[b].append(a)

BFS(1)

for i in range(2, N+1):
    print(parent_node[i])







