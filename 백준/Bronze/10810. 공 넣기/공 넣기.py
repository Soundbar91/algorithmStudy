Bucket_Number, Bucket_Ball = map(int, input().split())
Bucket = [0] * (Bucket_Number + 1)

for i in range(0, Bucket_Ball) :
    n1, n2, n3 = map(int, input().split())

    for j in range(n1 - 1, n2) :
        Bucket[j] = n3

for i in range(0, Bucket_Number) : print(Bucket[i], end=" ")