#include <stdio.h>

int main(){
    int num1, num2;
    
    scanf("%d %d", &num1, &num2);
    printf("%0.9lf", (double)num1/num2);
    
    return 0;
}