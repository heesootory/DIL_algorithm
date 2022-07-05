from sys import stdin

n = int(stdin.readline())
arr = [0 for _ in range(10001)]
f = 0

while n > 0:
    n-=1
    str = list(stdin.readline().split())
    if str[0] == "push":
        arr[f] = int(str[1])
        f+=1
    elif str[0] == "pop":
        if f == 0: print("-1")
        else:
            print(arr[f-1])
            arr[f-1] = 0
            f-=1
    elif str[0] == "size": print(f)
    elif str[0] == "empty":
        if f == 0: print("1")
        else: print("0")
    elif str[0] == "top":
        if f == 0 : print("-1")
        else: print(arr[f-1])

