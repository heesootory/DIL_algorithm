import sys
sys.setrecursionlimit(300000)       #파이썬은 재귀를 1000회만 기본으로 함으로, 제한을 늘려놓기

count_arr = [0 for _ in range(300000)]

def DFS(a,  p):
    new_a = 0
    while a > 0:
        new_a += (a % 10) ** p      # 파이썬은 제곱도 operater(**)가 존재
        a //= 10            # !주의 : 파이썬은 'float형'이 될 수 있는 /(한 개짜리 나누기) 와 'int형'으로 몫만 나오는 //(두 개짜리 나누기) 존재

    count_arr[new_a]+=1
    if count_arr[new_a] > 2 : return
    DFS(new_a, p)

A, P = map(int, input().split())
count_arr[A] += 1
DFS(A,P)
count = 0
for i in count_arr:
    if i == 1: count += 1
print(count)



