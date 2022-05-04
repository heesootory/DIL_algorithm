sick_finger = int(input())
can_count = int(input())

num_count = 0

if can_count == 0:
    for i in range(1, sick_finger):
        num_count+=1
else:
    if sick_finger == 1 or sick_finger == 5:
        num_count += (4*2*can_count)
        for i in range(1, sick_finger):
            num_count+=1
    else:
        num_count += (4*can_count)
        if can_count % 2 == 0:
            for i in range(1, sick_finger):
                num_count +=1
        else:
            for i in range(5, sick_finger, -1):
                num_count+=1

print(num_count)