import sys

n = eval(input())
inputList1 = list(map(int, sys.stdin.readline().rstrip().split()))
inputList1 = sorted(inputList1)

n1 = eval(input())
inputList2 = list(map(int, sys.stdin.readline().rstrip().split()))

def search(A, low, high, key) :
    if low > high : 
        return 0
    
    middle = (low + high) // 2
    
    if A[middle] == key :
        return 1
    elif A[middle] > key :
        return search(A, low, middle - 1, key)
    else :
        return search(A, middle + 1, high, key)

for i in inputList2 :
    print(search(inputList1, 0, len(inputList1) - 1, i))