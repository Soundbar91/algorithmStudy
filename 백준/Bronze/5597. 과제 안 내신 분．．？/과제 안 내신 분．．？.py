Student_Number = [0] * 30
Student_No = []

for i in range(len(Student_Number) - 2) :
    num = eval(input())
    Student_Number[num - 1] = 1

for i in range(len(Student_Number)) :
    if Student_Number[i] == 0 :
        Student_No.append(i + 1)

if Student_No[0] > Student_No[1] : 
    empty = Student_No[1]
    Student_No[1] = Student_No[0]
    Student_No[0] = empty
    
for i in range(0, 2) : 
    print(Student_No[i])