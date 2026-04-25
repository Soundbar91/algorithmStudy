import sys

inputList = set()
outputList = list()
cnt = 0

n, k = map(int, sys.stdin.readline().rstrip().split())

for i in range(n) :
    name = sys.stdin.readline().rstrip()
    inputList.add(name)

for j in range(k) :
    name = sys.stdin.readline().rstrip()
    
    if name in inputList :
        cnt += 1
        outputList.append(name)
        
print(cnt)
outputList = sorted(outputList)
for i in outputList :
    print(i)
