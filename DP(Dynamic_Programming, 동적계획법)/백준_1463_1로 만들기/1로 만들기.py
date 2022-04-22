import sys
sys.setrecursionlimit(300000)       #파이썬은 재귀를 1000회만 기본으로 함으로, 제한을 늘려놓기
min =1000000

def dp(x, count):
    global min          #파이썬은 전역변수를 global로 설정해줘야 지역내에서 사용이 가능.
    if x <= 1:
        if count < min: min = count
        return

    count+=1

    if x % 3 == 0:
        if count >= min: return
        dp(x/3, count)
    if x % 2 == 0:
        if count >= min: return
        dp(x/2, count)
    if count >= min: return
    dp(x-1, count)

    return

x = int(input())
dp(x, 0)
print(min)

