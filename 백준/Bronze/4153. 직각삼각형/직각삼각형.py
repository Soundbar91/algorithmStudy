OutPut = []

while (-1) :
    n1, n2, n3 = map(int, input().split())
    if n1 == n2 == n3 == 0 : break

    list = [n1,n2,n3]
    list.sort()
    if list[2] ** 2 != list[0] ** 2 + list[1] ** 2 : OutPut.append("wrong")
    else : OutPut.append("right")

for ch in OutPut : print(ch)