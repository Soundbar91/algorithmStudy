n = eval(input())
lst = []

for i in range(n) :
    x, y = map(int, input().split())
    lst.append((y, x))

lst.sort()

for i in range(len(lst)) :
    print("%d %d"%(lst[i][1], lst[i][0]))