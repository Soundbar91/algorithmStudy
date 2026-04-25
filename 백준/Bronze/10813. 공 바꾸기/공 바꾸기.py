Bucket_Number, Ball_Change = map(int, input().split())
Bucket = [0] * Bucket_Number

for i in range(0, Bucket_Number) :
    Bucket[i] = i + 1

for i in range(0, Ball_Change) :
    n1, n2 = map(int, input().split())

    empty = Bucket[n1 - 1]
    Bucket[n1 - 1] = Bucket[n2 - 1]
    Bucket[n2 - 1] = empty

for i in range(0, Bucket_Number) : print(Bucket[i], end=" ")