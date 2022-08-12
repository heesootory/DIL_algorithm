def room(stu, k):
    sum_room = 0
    sum_room += (stu//k)
    if stu % k != 0: sum_room += 1
    return sum_room

arr = [[0 for _ in range(6)] for _ in range(2)]

n,k = map(int, input().split(' '))

while n > 0:
    n-=1
    a,b = map(int, input().split(' '))
    arr[a][b-1] +=1

smw = arr[0][0] + arr[1][0] + arr[0][1] + arr[1][1];
mm = arr[1][2] + arr[1][3];
mw = arr[0][2] + arr[0][3];
hm = arr[1][4] + arr[1][5];
hw = arr[0][4] + arr[0][5];
sum = 0;
sum += room(smw, k);
sum += room(mm, k);
sum += room(mw, k);
sum += room(hm, k);
sum += room(hw, k);
print(sum)