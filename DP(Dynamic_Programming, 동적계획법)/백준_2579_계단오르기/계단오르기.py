stairs = [0 for _ in range(302)]
sum = [0 for _ in range(302)]

n = int(input())
for i in range(1, n+1):
    stairs[i] = int(input())
sum[1] = stairs[1]
sum[2] = stairs[1] + stairs[2]
sum[3] = max(stairs[1], stairs[2]) + stairs[3]
for i in range(4, n+1):
    sum[i] = max(sum[i-3] + stairs[i-1], sum[i-2]) + stairs[i]

print(sum[n])