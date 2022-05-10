_case = int(input())

def GCD(a,b):
    left = 0
    while(True):
        left = a % b
        if left == 0 : break
        a = b
        b = left
    return b

def LCD(a,b):
    gcd = GCD(a,b)
    return(a/gcd*b/gcd*gcd)

while True:
    _case-=1
    if _case < 0: break
    M,N,x,y = map(int, input().split(' '))

    i = x
    iss = False
    lcd = LCD(M,N)

    if N == y : y = 0
    while i <= lcd :
        if i % N == y:
            iss = True
            break
        i += M
    if iss : print(i)
    else: print(-1)

