a = int(input())
b = int(input())
c = int(input())
mul = a*b*c
arr = [0 for _ in range(10)]

while mul >= 1:
    i = int(mul % 10)
    arr[i] += 1
    mul /= 10

for i in range(len(arr)):
    print(arr[i])
