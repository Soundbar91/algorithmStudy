import sys

n = eval(input())
lst = []

for i in range(n):
    value = sys.stdin.readline()
    if value not in lst:
        lst.append(value)

lst.sort(key=lambda x: (len(x), x))

for i in lst: sys.stdout.write(i)