n = int(input())
arr = []

while n >= 1:
    arr.append(n %10)
    n //= 10

arr.sort(reverse = True)
for i in range(0, len(arr)):
    print(arr[i], end='')


