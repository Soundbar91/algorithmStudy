import sys

n = int(sys.stdin.readline())
Counting = [0] * 10001

for i in range(n):
    Input = int(sys.stdin.readline()) 
    Counting[Input] += 1

for i in range(len(Counting)):
    while Counting[i] > 0: 
        sys.stdout.write(str(i) + '\n') 
        Counting[i] -= 1