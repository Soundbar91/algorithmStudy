list = list(map(int, input().split()))
list.sort()

if list[0] + list[1] <= list[2] : 
    list[2] = (list[0] + list[1] - 1)
    print(sum(list))
elif list[0] == list[1] == list[2] : print(sum(list))
else : print(sum(list))
