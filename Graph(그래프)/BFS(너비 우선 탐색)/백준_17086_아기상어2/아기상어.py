
from collections import deque

n,m = map(int, input().split(' '))
max_cnt = 0
q = deque()
mx = [-1, -1, -1, 0, 1, 1, 1, 0]
my = [-1, 0, 1, 1, 1, 0, -1, -1]
sea = [[0 for _ in range(51)] for _ in range(51)]
class shark:
    x = 0
    y = 0
    def __init__(self, x, y):
        self.x = x
        self.y = y

def bfs():
    global max_cnt     # 상수는 메서드안에서 사용하려면, 전역변수화 시켜야함
    while len(q) != 0:
        sh = q.popleft()
        for p in range(8):
            new_x = sh.x + mx[p]
            new_y = sh.y + my[p]
            if new_x >= 0 and new_x < n and new_y >= 0 and new_y < m:
                if sea[new_x][new_y] == 0:
                    sea[new_x][new_y] = sea[sh.x][sh.y] + 1
                    sh_possible = shark(new_x, new_y)
                    q.append(sh_possible)
                    if sea[new_x][new_y] > max_cnt:
                        max_cnt = sea[new_x][new_y]

for i in range(0, n):
    inpu = input().split(' ')
    for j in range(0,m):
        sea[i][j] = int(inpu[j])
        sh_position = shark(i, j)
        if sea[i][j] == 1: q.append(sh_position)

bfs()
print(max_cnt-1)

