import sys

n, k = map(int, sys.stdin.readline().rstrip().split())
setA = set(map(int, sys.stdin.readline().rstrip().split()))
setB = set(map(int, sys.stdin.readline().rstrip().split()))

print(len((setA - setB) | (setB - setA)))
