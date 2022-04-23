ROW = 501
COL = 501

medow = [[',' for _ in range(ROW)] for _ in range(COL)]
mx = [0,1,0,-1]
my = [1,0,-1,0]

def printf(arr, r ,c):
    for i in range(0, r):
        for j in range(0, c):
            print(arr[i][j], end = '')
        print()

R,C = map(int, input().split())
defense = True
str = []
for i in range(0, R):
    str = input()
    for j in range(0, C):
        medow[i][j] = str[j]

for i in range(0, R):
    for j in range(0, C):
        if medow[i][j] == 'S':
            b = -1
            for a in range(0, 4):
                b+=1
                new_i = i + mx[a]
                new_j = j + my[b]
                if new_i < 0 | new_j < 0 | new_i > R -1 | new_j >C-1: continue
                if medow[new_i][new_j] == 'W': defense = False
                elif medow[new_i][new_j] == 'S' : continue
                elif medow[new_i][new_j] == 'D':continue
                else: medow[new_i][new_j] = 'D'

if defense :
    print("1")
    printf(medow, R, C)
else: print("0")
