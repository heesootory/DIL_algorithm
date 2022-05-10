from enum import Enum

class box_status(Enum):
    face = 0
    line = 1
    null = 3

def make_status(i,j,k,l):
    if k < i:
        if l <i:
            return box_status.null
        elif l == i :
            return box_status.line
        else: return box_status.face
    elif i <= k and k < j:
        return box_status.face
    elif k == j: return box_status.line
    else: return box_status.null

x1, y1, x2, y2 = map(int, input().split(' '))
a1, b1, a2, b2 = map(int, input().split(' '))

x_status = make_status(x1,x2,a1,a2)
y_status = make_status(y1,y2,b1,b2)

if x_status == box_status.null or y_status == box_status.null:
    print("NULL")
elif x_status == box_status.line and y_status == box_status.line:
    print("POINT")
elif x_status == box_status.face and y_status == box_status.face:
    print("FACE")
else: print("LINE")



