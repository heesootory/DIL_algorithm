x1,y1,x2,y2 = map(int, input().split(' '))
x3,y3,x4,y4 = map(int, input().split(' '))

def external_product(a1,b1,a2,b2,a3,b3):
    ans = ((a1 - a2) * (b2 - b3)) - ((a2 - a3) * (b1 - b2))
    if ans > 0:
        return 1
    elif ans < 0:
        return -1
    else:
        return 0

a = external_product(x1, y1, x2, y2, x3, y3)
b = external_product(x1, y1, x2, y2, x4, y4)
c = external_product(x3, y3, x4, y4, x1, y1)
d = external_product(x3, y3, x4, y4, x2, y2)

if a*b <= 0 and c*d <= 0:
    print("1")
else: print("0")
