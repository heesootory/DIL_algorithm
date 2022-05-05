def count_zero(n, k):
    cnt = 0
    i = k
    while i <= n:
        cnt += (n//i)
        i *= k
    return cnt

n, m = map(int, input().split(' '))

f = count_zero(n, 5) - count_zero(m, 5) - count_zero(n-m, 5)
t = count_zero(n, 2) - count_zero(m, 2) - count_zero(n-m, 2)

print(min(f, t))