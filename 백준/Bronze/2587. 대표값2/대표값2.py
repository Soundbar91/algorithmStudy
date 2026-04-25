List = [int(input()) for _ in range(5)]

for i in range(1, len(List)) :
    key = List[i]
    j = i - 1

    while j >= 0 and List[j] > key :
        List[j + 1] = List[j]
        j -= 1

    List[j + 1] = key

print(sum(List) // 5)
print(List[2])