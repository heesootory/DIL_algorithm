N = int(input())

sum = 0
m = 9
ten_mul = 10
i = 1
norm = m

while N > norm:
    N -= norm
    sum += norm *i
    i +=1
    norm = m * pow(ten_mul, i-1)
sum += N *i
print(sum)