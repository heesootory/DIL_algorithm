arr = [0 for _ in range (42)]
a = 0;
num = 10

while num > 0:
    num -=1
    a = int(input())
    arr[a%42] += 1

cnt = 0
for i in range(42):
    if arr[i] > 0: cnt += 1

print(cnt)