def is_prime(k):
    for i in range(2, k+1):
        if i*i > k:
            break
        if k % i == 0:
            return False
    return True

while(True):
    n = int(input())
    if n == 0:
        break
    count = 0

    for i in range(n+1, 2*n+1):
        if is_prime(i):
            count += 1
    print(count)