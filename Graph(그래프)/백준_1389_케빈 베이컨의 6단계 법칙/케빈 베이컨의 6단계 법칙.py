from collections import deque
max_num = 101
n, m = map(int, input().split(' '))
user = [[0 for _ in range(max_num)] for _ in range(max_num)]
check = [False for _ in range(max_num)]
friends = [0 for _ in range(max_num)]
min_count = max_num
q = deque()

for i in range(m):
    a, b = map(int, input().split(' '))
    user[a].append(b)
    user[b].append(a)

def bfs(n):
    q.append(n)
    check[n] = True
    while len(q) != 0:
        f = q.popleft()
        for i in user[f]:
            if check[i] == False:
                check[i] = True
                friends[i] = friends[f]+1
                q.append(i)
def friends_init_sum():
    sum = 0
    for i in range(1, n+1):
        sum += friends[i]
        friends[i] = 0
    return sum
def check_init():
    for i in range(0, n+1): check[i] = False

min_who = 0
for i in range(1,n+1):
    bfs(i)
    check_init()
    fri_sum = friends_init_sum()
    if fri_sum < min_count:
        min_count = fri_sum
        min_who = i
print(min_who)