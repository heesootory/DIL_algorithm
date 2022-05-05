def is_prime(k):
    for i in range(2, k+1):
        if i*i > k:
            break
        if k % i == 0:
            return False
    return True

while(True):
    n = int(input())

    if n == 0: break
    for i in range(3, n, 2):
        if is_prime(i) and is_prime(n-i):
            a = i
            break
    if a == 0:
        print("Goldbach's conjecture is wrong.")
    else:
        print(f'{n} = {a} + {n-a}')