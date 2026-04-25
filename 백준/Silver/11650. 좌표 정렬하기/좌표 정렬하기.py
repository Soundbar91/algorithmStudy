n = eval(input())
lst = []

for i in range(n) :
    x, y = map(int, input().split())
    lst.append((x, y))

lst.sort()

for i in range(len(lst)) :
    print("%d %d"%(lst[i][0], lst[i][1]))