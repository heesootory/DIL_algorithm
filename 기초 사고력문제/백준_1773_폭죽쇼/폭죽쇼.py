n,c = map(int, input().split())
time = []
fire = [0 for i in range(c+1)]
for i in range(n):
    time.append(int(input()))

cnt = 0
for i in range(n):
    for j in range(time[i], c+1, time[i]):
        if fire[j] == 1: continue
        fire[j] = 1
        cnt+=1

print(cnt)




