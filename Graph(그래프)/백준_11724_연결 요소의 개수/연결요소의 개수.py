check = [False for _ in range(1001)]
arr_list = [[]for _ in range(1001)]

N, M = map(int, input().split(' '))
count = 0

for i in range(0,M):
    a, b = map(int, input().split(' '))
    arr_list[a].append(b)
    arr_list[b].append(a)

def DFS(n):
    for i in arr_list[n]:
        if(check[i] == False):
            check[i] = True
            DFS(i)

for i in range(1, N+1):
    if check[i] == False:
        check[i] = True
        count+=1
        DFS(i)

print(count)

