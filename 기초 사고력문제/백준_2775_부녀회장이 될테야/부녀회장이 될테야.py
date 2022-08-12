apt = [[0 for _ in range(15)] for _ in range(15)]

for i in range(len(apt)):
    for j in range(len(apt[i])):
        if i == 0: apt[i][j] = j
        else:
            if j == 1: apt[i][j] = 1
            elif j > 1: apt[i][j] = apt[i-1][j] + apt[i][j-1]

t = int(input())
while t > 0 :
    t-=1
    k = int(input())
    n = int(input())
    print(apt[k][n])