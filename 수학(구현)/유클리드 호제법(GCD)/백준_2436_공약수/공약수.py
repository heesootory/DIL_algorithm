def GCD(a,b):
    p = max(a,b)
    q = min(a,b)
    left = p%q
    while left != 0:
        p = q
        q = left
        left = p % q
    return q

g,l = map(int, input().split(' '))
if g == l:
    print(f'{g} {g}')
else:
    p = l//g
    sum = p+2
    a = 0
    b = 0
    for i in range(1, p):
        if p % i == 0:
            j = p // i
            if GCD(i, j) == 1:
                if i + j < sum:
                    sum = i + j
                    a = i
                    b = j
                else:
                    break
    if a < b:
        print(f'{a*g} {b*g}')
    else:
        print(f'{b*g} {a*g}')