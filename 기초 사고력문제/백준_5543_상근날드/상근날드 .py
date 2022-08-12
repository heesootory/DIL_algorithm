min1 = 2000
for i in range(3):
    burger = int(input())
    if burger < min1: min1 = burger
min2 = 2000
for i in range(2):
    drink = int(input())
    if drink < min2: min2 = drink

print(f'{min1 + min2 -50}')