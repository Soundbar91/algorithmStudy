n = int(input())
lst = []

for i in range(n) :
    age, name = input().split()
    lst.append((int(age), i, name))

lst.sort()

for i in range(n) :
    print(lst[i][0], lst[i][2])