Bucket_Number, Reverse_Range = map(int, (input().split()))
Bucket = [0]

for i in range(1, Bucket_Number + 1) :
    Bucket.append(i)

for i in range(Reverse_Range) :
    n1, n2 = map(int, (input().split()))
    
    for j in range(n1,((n1 + n2) // 2) + 1) :
            empty = Bucket[j]
            Bucket[j] = Bucket[n2]
            Bucket[n2] = empty
            n2 -= 1
    
for i in range(1, len(Bucket)) : print(Bucket[i], end = " ")