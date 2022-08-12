a,b,c = map(int, input().split())
arr = []
for i in [a,b,c]:
    arr.append(i)
arr.sort()
print(f'{arr[1]}')