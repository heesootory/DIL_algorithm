N = int(input())
d = [0 for _ in range(50)]
d[1] = 1
for i in range(2, N+1):
    d[i] = d[i-1] + d[i-2]

print(d[N])

#파이썬은 메모리 초과 문제로 "bottom - up" 방식으로 해결