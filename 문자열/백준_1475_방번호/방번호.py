n = int(input())
arr = [0 for _ in range(0, 10)]

while n >= 1:
    i = n % 10
    if i == 9: i = 6
    arr[i] += 1
    n //= 10

arr[6] = arr[6] // 2 if arr[6] % 2 == 0 else arr[6] // 2 + 1
_max = 0
for i in arr:
    if i > _max: _max = i
print(_max)

