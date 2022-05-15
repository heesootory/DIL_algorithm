import math

def mid_height(x,y,m):
    h1 = math.sqrt(pow(x,2) - pow(m,2))
    h2 = math.sqrt(pow(y, 2) - pow(m, 2))

    return (h1*h2)/(h1+h2)

x,y,c = map(float, input().split(' '))      # float로 실수로 입력받기
max_len = min(x,y)
min_len = 0
mid = 0

while max_len-min_len > 0.000001:
    mid = (max_len + min_len) / 2.0
    result = mid_height(x,y,mid)

    if c <= result: min_len = mid
    else: max_len = mid

print(f'{mid:.3f}')     # 소수점 3자리까지 출력


