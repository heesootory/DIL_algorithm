from collections import deque

q = deque()
a, b = map(int, input().split(' '))
_move = []
check = [False for _ in range(200001)]      #파이썬만 100001할 시, indexerror
seconds = [0 for _ in range(200001)]

def bfs(n):
    q.append(n)
    check[n] = True
    while len(q) != 0:
        f = q.popleft()
        _move.append(f-1)
        if f < b:
            _move.append(f+1)
            _move.append(f*2)
        for i in _move:
            if i >= 0 and i <= 100000:
                if check[i] == False:
                    check[i] = True
                    q.append(i)
                    seconds[i] = seconds[f] + 1
                    if i == b:
                        return
        _move.clear()

bfs(a)
print(seconds[b])