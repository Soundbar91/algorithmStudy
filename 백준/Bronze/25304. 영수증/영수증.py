Product_Sum_Price = eval(input())
Product_Sum_Count = eval(input())

Product_Price = list(range(Product_Sum_Count))
Product_Count = list(range(Product_Sum_Count))
Product_Sum = 0

for i in range(0, Product_Sum_Count) :
    Product_Price[i], Product_Count[i] = input().split()
    Product_Price[i] = eval(Product_Price[i])
    Product_Count[i] = eval(Product_Count[i])
    Product_Sum += Product_Count[i] * Product_Price[i]

print("Yes" if Product_Sum_Price == Product_Sum else "No")