arr = [[0 for _ in range(52)] for _ in range(52)]
def DFS(i, j):
    if arr[i][j] == 0:
        return
    arr[i][j] = 0
    DFS(i + 1, j)
    DFS(i + 1, j - 1)
    DFS(i + 1, j + 1)
    DFS(i, j - 1)
    DFS(i, j + 1)
    DFS(i - 1, j)
    DFS(i - 1, j - 1)
    DFS(i - 1, j + 1)

while(1):
    inpu = []
    w, h = map(int, input().split())
    if w == 0 & h == 0:
        break
    count = 0
    for i in range(1, h+1):
        inpu = list(map(int, input().split()))
        for j in range(1, w+1):
            arr[i][j] = inpu[j-1]

    for i in range(1, h+1):
        for j in range(1, w+1):
            if arr[i][j] == 1 :
                count += 1
                DFS(i,j)
    print(count)