Output_String = []

while True :
    try :
        Input_String = input()
        Output_String.append(Input_String)
        
    except: break

for i in range(len(Output_String)) :
    print(Output_String[i])