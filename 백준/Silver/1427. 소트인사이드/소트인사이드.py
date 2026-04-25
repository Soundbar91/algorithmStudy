n = input()
lst = []

for i in range(len(n)) :
    lst.append(n[i])

lst.sort(reverse = True)

for i in lst : print(i, end = "")