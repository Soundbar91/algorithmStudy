n, k = map(int, input().split())
List = [int(x) for x in input().split()]

for i in range(1, len(List)) :
    key = List[i]
    j = i - 1

    while j >= 0 and List[j] > key :
        List[j + 1] = List[j]
        j -= 1

    List[j + 1] = key

print(List[len(List) - k])